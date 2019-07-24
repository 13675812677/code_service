package com.mchain.transport.auth.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mchain.transport.auth.entity.AuthRole;

public interface AuthRoleRepository extends JpaSpecificationExecutor<AuthRole>, PagingAndSortingRepository<AuthRole, String> {

}

