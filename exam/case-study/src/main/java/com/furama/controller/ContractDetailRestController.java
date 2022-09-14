package com.furama.controller;

import com.furama.model.contract.ContractDetail;
import com.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/restContractDetail")
public class ContractDetailRestController {
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("{id}")
    public ResponseEntity<List<ContractDetail>> getAllContractDetail(@PathVariable Integer id) {
        List<ContractDetail> contractDetails = iContractDetailService.findByAllContractDetailById(id);
        if (contractDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDetails, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveContractDetail(@RequestBody ContractDetail contractDetail) {
        iContractDetailService.save(contractDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
