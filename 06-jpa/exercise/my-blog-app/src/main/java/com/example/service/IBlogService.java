package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findBlogById(int id);

    void saveBlog(Blog blog);

    void deleteBlogById(int id);
}
