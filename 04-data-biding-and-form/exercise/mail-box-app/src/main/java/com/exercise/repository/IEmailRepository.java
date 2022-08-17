package com.exercise.repository;

import java.util.List;

public interface IEmailRepository {
    List<String> findAllLanguages();

    List<Integer> findAllPageSize();
}
