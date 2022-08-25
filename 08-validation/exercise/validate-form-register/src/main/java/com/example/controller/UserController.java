package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showFormAdd(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "add";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult,
                           Model model) {
        if(bindingResult.hasErrors()) {
            return "add";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setBirthDay(LocalDate.parse(userDto.getBirthDay()));
        iUserService.saveUser(user);
        model.addAttribute("message", "Đã thêm thành công: " + user.getLastName());
        return "result";
    }
}
