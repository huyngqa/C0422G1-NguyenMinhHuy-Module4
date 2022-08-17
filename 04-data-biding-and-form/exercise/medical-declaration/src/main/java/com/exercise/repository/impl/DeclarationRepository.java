package com.exercise.repository.impl;

import com.exercise.model.Declaration;
import com.exercise.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DeclarationRepository implements IDeclarationRepository {
    private static Map<Integer, Declaration> declarations = new HashMap<>();

    static {
        declarations.put(1, (new Declaration(1, "Nguyen Minh Huy", "1999", "Nam",
                "Việt Nam", "192849201", "Tàu bay",
                "VN123", "1", "12", "10", "2022",
                "12", "11", "2022", "Không")));
    }

    @Override
    public Map<Integer, Declaration> getAllDeclaration() {
        return declarations;
    }

    @Override
    public void addNewDeclaration(Declaration declaration) {
        int id = (int) (Math.random() * 1000);
        declaration.setId(id);
        declarations.put(id, declaration);
    }

    @Override
    public Declaration findById(int id) {
        return declarations.get(id);
    }

    @Override
    public void updateDeclaration(Declaration declaration) {
        declarations.replace(declaration.getId(), declaration);
    }
}
