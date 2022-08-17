package com.exercise.service.impl;

import com.exercise.repository.IDataDeclarationRepository;
import com.exercise.service.IDataDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDeclarationService implements IDataDeclarationService {
    @Autowired
    private IDataDeclarationRepository iDataDeclarationRepository;

    @Override
    public List<String> getAllGenders() {
        return iDataDeclarationRepository.getAllGenders();
    }

    @Override
    public List<String> getAllYears() {
        return iDataDeclarationRepository.getAllYears();
    }

    @Override
    public List<String> getAllDays() {
        return iDataDeclarationRepository.getAllDays();
    }

    @Override
    public List<String> getAllMonths() {
        return iDataDeclarationRepository.getAllMonths();
    }

    @Override
    public List<String> getAllTravels() {
        return iDataDeclarationRepository.getAllTravels();
    }

    @Override
    public List<String> getAllNations() {
        return iDataDeclarationRepository.getAllNations();
    }
}
