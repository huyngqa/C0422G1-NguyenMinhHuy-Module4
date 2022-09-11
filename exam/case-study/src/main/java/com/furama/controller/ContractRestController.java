package com.furama.controller;

import com.furama.model.contract.Contract;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("restContract")
public class ContractRestController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("")
    public ResponseEntity<Page<Contract>> getContracts(@RequestParam(defaultValue = "") String keyword,@PageableDefault(size = 5) Pageable pageable) {
        Page<Contract> contracts = iContractService.findAllContractUsed(LocalDate.now(), keyword, pageable);
        if (!contracts.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }
}
