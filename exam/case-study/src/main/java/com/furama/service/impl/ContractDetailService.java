package com.furama.service.impl;

import com.furama.model.contract.ContractDetail;
import com.furama.repository.IContractDetailRepository;
import com.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findByAllContractDetailById(Integer id) {
        return iContractDetailRepository.findAllByContract_Id(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
