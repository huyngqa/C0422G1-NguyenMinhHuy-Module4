package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/listCategory")
    public ResponseEntity<Page<Category>> getListCategoriesRest(@PageableDefault(size = 3) Pageable pageable) {
        Page<Category> categoryPage = iCategoryService.findAllCategory(pageable);
        if (!categoryPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }

    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> getListBlogsRest(@PageableDefault(size = 3) Pageable pageable) {
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryRest(@PathVariable int id) {
        Optional<Category> category = Optional.ofNullable(iCategoryService.findCategoryById(id));
        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogRest(@PathVariable int id) {
        Optional<Blog> blog = Optional.ofNullable(iBlogService.findBlogById(id));
        if (blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
}