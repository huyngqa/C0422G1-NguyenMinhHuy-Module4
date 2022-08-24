package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = {"", "/search", "/list"})
    public String showListProduct(@RequestParam(defaultValue = "") String keyword,
                                  @PageableDefault(size = 3) Pageable pageable,
                                  Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("products", this.iProductService.findAllProduct(keyword, pageable));
        return "index";
    }

    @GetMapping("/create")
    public String showFormAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/create")
    public String addProduct(@ModelAttribute Product product,
                             RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg",
                "Thêm mới thành công sản phẩm: " + product.getProductName());
        return "redirect:list";
    }

    @GetMapping("details")
    public String showDetailsProduct(@RequestParam int id, Model model) {
        Product product = this.iProductService.getProductById(id);
        model.addAttribute("product", product);
        return "details";
    }

    @GetMapping("/update")
    public String showFormUpdateProduct(@RequestParam int id, Model model) {
        Product product = this.iProductService.getProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg",
                "Đã chỉnh sửa thành công");
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        this.iProductService.deleteProduct(idDelete);
        redirectAttributes.addFlashAttribute("msg",
                "Đã xoá thành công");
        return "redirect:/list";
    }
}
