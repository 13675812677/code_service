package com.mchain.transport.auth.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;

@Component
public class JwtTokenUtil implements Serializable {

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_CREATED = "iat";
    private static final long serialVersionUID = -3301605591108950415L;
    //@SuppressFBWarnings(value = "SE_BAD_FIELD", justification = "It's okay here")
    private Clock clock = DefaultClock.INSTANCE;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        if(claims == null) return null;
        return claimsResolver.apply(claims);
    }
    
    public Long getUserIdFromToken(String token) {
    	Claims claims = this.getAllClaimsFromToken(token);
    	if(claims == null) return null;
    	Long userId = new Long(claims.get("userId").toString());
    	return userId;
    }

    private Claims getAllClaimsFromToken(String token) {
    	try {
	        return Jwts.parser()
	            .setSigningKey(secret)
	            .parseClaimsJws(token)
	            .getBody();
    	}catch(Exception e) {
    		return null;
    	}
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<String, Object>();
        if(userDetails instanceof JwtUserDetails) {
        	claims.put("userId", ((JwtUserDetails) userDetails).getUserId());
        }
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(createdDate)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getIssuedAtDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
            && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public String refreshToken(String token) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUserDetails user = (JwtUserDetails) userDetails;
        final String username = getUsernameFromToken(token);
        final Date created = getIssuedAtDateFromToken(token);
        //final Date expiration = getExpirationDateFromToken(token);
        return (
            username.equals(user.getUsername())
                && !isTokenExpired(token)
                && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate())
        );
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }
}
