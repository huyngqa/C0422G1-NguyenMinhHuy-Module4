package com.furama.service.impl;

import com.furama.model.contract.Contract;
import com.furama.repository.IContractRepository;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAllContractUsed(LocalDate endDate,String nameCustomer, Pageable pageable) {
        return iContractRepository.findAllByEndDateGreaterThanEqualAndCustomer_NameContaining
                (endDate, nameCustomer, pageable);
    }
}
