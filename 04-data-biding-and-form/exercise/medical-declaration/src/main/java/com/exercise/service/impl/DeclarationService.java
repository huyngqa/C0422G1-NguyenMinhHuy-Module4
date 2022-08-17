package com.exercise.service.impl;

import com.exercise.model.Declaration;
import com.exercise.repository.IDeclarationRepository;
import com.exercise.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeclarationService implements IDeclarationService {
    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public Map<Integer, Declaration> getAllDeclaration() {
        return iDeclarationRepository.getAllDeclaration();
    }

    @Override
    public void addNewDeclaration(Declaration declaration) {
        iDeclarationRepository.addNewDeclaration(declaration);
    }

    @Override
    public Declaration findById(int id) {
        return iDeclarationRepository.findById(id);
    }

    @Override
    public void updateDeclaration(Declaration declaration) {
        iDeclarationRepository.updateDeclaration(declaration);
    }
}
