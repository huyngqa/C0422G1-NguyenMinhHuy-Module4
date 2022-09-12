package com.furama.controller;

import com.furama.model.facility.Facility;
import com.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("facilityRest")
public class FacilityRestController {
    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("")
    public ResponseEntity<List<Facility>> getAllFacility() {
        List<Facility> facilityList = iFacilityService.findAllFacility();
        if(facilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facilityList, HttpStatus.OK);
    }
}
