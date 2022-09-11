package com.furama.service;

import com.furama.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findByAllContractDetailById(Integer id);
}
