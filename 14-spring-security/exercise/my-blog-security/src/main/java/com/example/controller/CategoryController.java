package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"", "/list"})
    public String showListCategory(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("categories", this.iCategoryService.findAllCategory(pageable));
        return "list-categories";
    }

    @GetMapping("/create")
    public String showFormAdd(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @PostMapping("/save")
    public String addCategory(@ModelAttribute Category category,
                                   RedirectAttributes redirectAttributes) {
        this.iCategoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message", "Đã thêm thành công");
        return "redirect:/category";
    }

    @GetMapping("/update")
    public String showFormEdit(@RequestParam int id, Model model) {
        model.addAttribute("category", this.iCategoryService.findCategoryById(id));
        return "edit-category";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category,
                                   RedirectAttributes redirectAttributes) {
        this.iCategoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message", "Đã thêm thành công");
        return "redirect:/category";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        this.iCategoryService.deleteCategoryById(idDelete);
        redirectAttributes.addFlashAttribute("message", "Đã xoá");
        return "redirect:/category";
    }
}
