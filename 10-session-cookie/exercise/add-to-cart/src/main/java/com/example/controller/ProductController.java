package com.example.controller;

import com.example.model.Product;
import com.example.service.ICartService;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> createCart() {
        return new HashMap<>();
    }

    @GetMapping("")
    public String showShop(Model model) {
        model.addAttribute("products", iProductService.findAll());
        return "index";
    }

    @GetMapping("details")
    public String goDetailPage(@RequestParam Long id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "details";
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam Long id,
                             @SessionAttribute("cart") Map<Product, Integer> cart) {

        Product product = this.iProductService.findById(id);
        iCartService.addProduct(cart, product);

        return "redirect:";
    }

    @GetMapping("/cart")
    public String goCart(Model model, @SessionAttribute("cart") Map<Product, Integer> cart) {
        double total = iCartService.getTotal(cart);
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "cart";
    }
}
