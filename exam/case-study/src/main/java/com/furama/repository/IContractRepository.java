package com.furama.repository;

import com.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByEndDateGreaterThanEqualAndCustomer_NameContaining
            (LocalDate endDate,String nameCustomer, Pageable pageable);
}
