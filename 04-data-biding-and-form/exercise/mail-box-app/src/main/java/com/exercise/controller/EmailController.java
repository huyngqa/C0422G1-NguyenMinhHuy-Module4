package com.exercise.controller;

import com.exercise.model.Email;
import com.exercise.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @Autowired
    private IEmailService iEmailService;

    @GetMapping("")
    public String showFormSetting(Model model) {
        model.addAttribute("email", new Email());
        model.addAttribute("languages", this.iEmailService.findAllLanguages());
        model.addAttribute("pageSizeList", this.iEmailService.findAllPageSize());
        return "index";
    }

    @PostMapping("/settings")
    public String updateEmail(@ModelAttribute Email email, Model model) {
        model.addAttribute("email",email);
        return "details";
    }
}
