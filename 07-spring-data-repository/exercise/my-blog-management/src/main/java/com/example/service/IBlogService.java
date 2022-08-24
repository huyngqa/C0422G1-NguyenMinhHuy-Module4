package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(String keyword, String categoryName, Pageable pageable);

    Blog findBlogById(int id);

    void saveBlog(Blog blog);

    void deleteBlogById(int id);
}
