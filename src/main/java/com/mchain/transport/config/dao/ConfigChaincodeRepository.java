package com.mchain.transport.config.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mchain.transport.config.entity.ConfigChaincode;

public interface ConfigChaincodeRepository extends JpaSpecificationExecutor<ConfigChaincode>, PagingAndSortingRepository<ConfigChaincode, String> {

}

