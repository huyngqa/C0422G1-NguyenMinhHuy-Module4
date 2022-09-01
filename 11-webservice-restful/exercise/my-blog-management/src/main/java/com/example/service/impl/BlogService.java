package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(String keyword, String categoryName, Pageable pageable) {
        return iBlogRepository.findAllByTitleContainingAndCategory_CategoryNameContaining(keyword, categoryName, pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findBlogById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        if(blog.getId() == 0) {
            blog.setCreationTime();
        }
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAllBlogByCategoryId(int id) {
        return iBlogRepository.findAllByCategory_Id(id);
    }

}
