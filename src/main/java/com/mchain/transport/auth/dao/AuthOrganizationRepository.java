package com.mchain.transport.auth.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mchain.transport.auth.entity.AuthOrganization;

public interface AuthOrganizationRepository extends JpaSpecificationExecutor<AuthOrganization>, PagingAndSortingRepository<AuthOrganization, String> {

}

