package com.example.service;

import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Category findCategoryById(int id);

    void saveCategory(Category category);

    Page<Category> findAllCategory(Pageable pageable);

    void deleteCategoryById(int id);

    List<Category> findAllCategory();
}
