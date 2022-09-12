package com.furama.service;

import com.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAllFacility(String keyword, Pageable pageable);

    Facility findFacilityById(int id);

    void saveFacility(Facility facility);

    void removeFacilityById(int id);

    List<Facility> findAllFacility();
}
