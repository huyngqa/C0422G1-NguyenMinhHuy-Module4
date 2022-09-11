package com.furama.controller;

import com.furama.model.contract.Contract;
import com.furama.service.IContractDetailService;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("")
    public String goContract() {
        return "contract/list";
    }
}
