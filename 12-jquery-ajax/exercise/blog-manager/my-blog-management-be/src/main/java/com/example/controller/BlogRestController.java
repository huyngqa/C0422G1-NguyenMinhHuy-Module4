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

@CrossOrigin
@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> getListBlogsRest(@RequestParam(defaultValue = "") String title, @PageableDefault(size = 3) Pageable pageable) {
        Page<Blog> blogPage = iBlogService.findAllByTitle(title, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
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