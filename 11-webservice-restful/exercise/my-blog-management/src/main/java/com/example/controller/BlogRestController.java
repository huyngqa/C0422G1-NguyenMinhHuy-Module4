package com.example.controller;

import com.example.dto.BlogDTO;
import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<List<Blog>> getCategoryRest(@PathVariable int id) {
        List<Blog> blogs = iBlogService.findAllByByCategory_Id(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogRest(@PathVariable int id) {
        Optional<Blog> blog = iBlogService.findBlogById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBlog/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable int id) {
        Optional<Blog> blog = iBlogService.findBlogById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.deleteBlogById(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @PostMapping("/addBlog")
    public ResponseEntity<Map<String, String>> addBlog(@RequestBody @Valid BlogDTO blogDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        blog.setCategory(iCategoryService.findCategoryById(Integer.parseInt(blogDTO.getCategory())));
        blog.setCreationTime();
        iBlogService.saveBlog(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}