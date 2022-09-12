package com.furama.service.impl;

import com.furama.model.facility.Facility;
import com.furama.repository.IFacilityRepository;
import com.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllFacility(String keyword, Pageable pageable) {
        return iFacilityRepository.findAllByNameContaining(keyword, pageable);
    }

    @Override
    public Facility findFacilityById(int id) {
        return iFacilityRepository.findById(id).get();
    }

    @Override
    public void saveFacility(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void removeFacilityById(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public List<Facility> findAllFacility() {
        return iFacilityRepository.findAll();
    }
}
