package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String goHomePage(Model model) {
        model.addAttribute("blogList", this.iBlogService.findAll());
        return "index";
    }

    @GetMapping("/write")
    public String showFormBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String saveNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Tiến trình thành công");
        return "redirect:";
    }

    @GetMapping("/update")
    public String showFormEdit(@RequestParam int id, Model model) {
        model.addAttribute("blog", this.iBlogService.findBlogById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:";
    }

    @GetMapping("/details")
    public String showDetailsBlog(@RequestParam int id, Model model) {
        model.addAttribute("blog", this.iBlogService.findBlogById(id));
        return "details";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        this.iBlogService.deleteBlogById(idDelete);
        redirectAttributes.addFlashAttribute("message", "Đã xoá");
        return "redirect:";
    }
}
