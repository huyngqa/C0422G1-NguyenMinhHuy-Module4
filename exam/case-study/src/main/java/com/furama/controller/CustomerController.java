package com.furama.controller;

import com.furama.model.customer.Customer;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = {"", "list"})
    public String goListCustomer(@PageableDefault(size = 5) Pageable pageable,
                                 Model model) {
        model.addAttribute("customers", iCustomerService.findAllCustomer(pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String goFormCreateCustomer(Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAllCustomerType());
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute Customer customer,
                                    RedirectAttributes redirectAttributes) {
        iCustomerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message",
                "Đã thêm thành công khách hàng: " + customer.getName());
        return "redirect:/customer/list";
    }

    @GetMapping("/update")
    public String goFormUpdateCustomer(@RequestParam int id, Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAllCustomerType());
        model.addAttribute("customer", iCustomerService.findCustomerById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer,
                                 RedirectAttributes redirectAttributes) {
        iCustomerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message",
                "Đã cập nhật thành công");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iCustomerService.removeCustomerById(deleteId);
        redirectAttributes.addFlashAttribute("message",
                "Đã cập nhật thành công");
        return "redirect:/customer/list";
    }
}
