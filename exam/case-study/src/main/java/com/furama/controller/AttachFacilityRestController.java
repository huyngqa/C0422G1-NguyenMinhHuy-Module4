package com.furama.controller;

import com.furama.model.facility.AttachFacility;
import com.furama.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attachRest")
public class AttachFacilityRestController {
    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @GetMapping("")
    public ResponseEntity<List<AttachFacility>> goAllAttachFacility() {
        List<AttachFacility> attachFacilities = iAttachFacilityService.findAllAttachFacility();
        if(attachFacilities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilities, HttpStatus.OK);
    }
}
