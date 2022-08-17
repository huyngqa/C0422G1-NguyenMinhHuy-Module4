package com.exercise.service;

import com.exercise.model.Declaration;

import java.util.Map;

public interface IDeclarationService {
    Map<Integer, Declaration> getAllDeclaration();

    void addNewDeclaration(Declaration declaration);

    Declaration findById(int id);

    void updateDeclaration(Declaration declaration);
}
