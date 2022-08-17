package com.exercise.controller;

import com.exercise.model.Declaration;
import com.exercise.service.IDeclarationService;
import com.exercise.service.IDataDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeclarationController {
    @Autowired
    private IDeclarationService iDeclarationService;

    @Autowired
    private IDataDeclarationService iDataDeclarationService;

    @GetMapping("/list")
    public String showListDeclaration(Model model) {
        model.addAttribute("declarations", this.iDeclarationService.getAllDeclaration());
        return "list";
    }

    @GetMapping("")
    public String showMedicalDeclaration(Model model) {
        model.addAttribute("genders", this.iDataDeclarationService.getAllGenders());
        model.addAttribute("days", this.iDataDeclarationService.getAllDays());
        model.addAttribute("months", this.iDataDeclarationService.getAllMonths());
        model.addAttribute("years", this.iDataDeclarationService.getAllYears());
        model.addAttribute("travels", this.iDataDeclarationService.getAllTravels());
        model.addAttribute("nations", this.iDataDeclarationService.getAllNations());
        model.addAttribute("declaration", new Declaration());
        return "create";
    }

    @PostMapping("/addNew")
    public String addNewDeclaration(@ModelAttribute Declaration declaration,
                                    RedirectAttributes redirectAttributes) {
        this.iDeclarationService.addNewDeclaration(declaration);
        redirectAttributes.addFlashAttribute("msg", "Thêm tờ khai thành công");
        return "redirect:list";
    }

    @GetMapping("/update")
    public String showFormEdit(@RequestParam int id, Model model) {
        model.addAttribute("genders", this.iDataDeclarationService.getAllGenders());
        model.addAttribute("days", this.iDataDeclarationService.getAllDays());
        model.addAttribute("months", this.iDataDeclarationService.getAllMonths());
        model.addAttribute("years", this.iDataDeclarationService.getAllYears());
        model.addAttribute("travels", this.iDataDeclarationService.getAllTravels());
        model.addAttribute("nations", this.iDataDeclarationService.getAllNations());
        model.addAttribute("declaration", this.iDeclarationService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateDeclaration(@ModelAttribute Declaration declaration,
                                    RedirectAttributes redirectAttributes) {
        this.iDeclarationService.updateDeclaration(declaration);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công");
        return "redirect:list";
    }
}
