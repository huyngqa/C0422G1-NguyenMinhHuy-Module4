package com.furama.service;

import com.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IContractService {
    Page<Contract> findAllContractUsed
            (LocalDate endDate,String nameCustomer, Pageable pageable);
    void save(Contract contract);

    Contract getContractByID(Integer id);
}
