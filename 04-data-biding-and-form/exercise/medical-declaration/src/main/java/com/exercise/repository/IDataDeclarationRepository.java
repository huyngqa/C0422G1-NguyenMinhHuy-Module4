package com.exercise.repository;

import java.util.List;

public interface IDataDeclarationRepository {
    List<String> getAllGenders();

    List<String> getAllYears();

    List<String> getAllDays();

    List<String> getAllMonths();

    List<String> getAllTravels();

    List<String> getAllNations();
}
