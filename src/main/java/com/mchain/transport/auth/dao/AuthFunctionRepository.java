package com.mchain.transport.auth.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mchain.transport.auth.entity.AuthFunction;

public interface AuthFunctionRepository extends JpaSpecificationExecutor<AuthFunction>, PagingAndSortingRepository<AuthFunction, String> {

}

