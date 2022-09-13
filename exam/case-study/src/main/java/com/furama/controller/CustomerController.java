package com.furama.controller;

import com.furama.dto.CustomerDTO;
import com.furama.dto.CustomerTypeDTO;
import com.furama.model.person.Customer;
import com.furama.model.person.CustomerType;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute
    public void getCustomerType(Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAllCustomerType());
    }
    @GetMapping(value = {"", "/list"})
    public String goListCustomer(@RequestParam(defaultValue = "") String keyword,
                                 @PageableDefault(size = 5) Pageable pageable,
                                 Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("customers", iCustomerService.findAllCustomer(keyword, keyword, keyword, pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String goFormCreateCustomer(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO());
        return "customer/add";
    }

    @PostMapping("/save")
    public String createNewCustomer(@ModelAttribute @Valid CustomerDTO customerDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customer.setDateOfBirth(LocalDate.parse(customerDTO.getDateOfBirth()));
        customer.setGender(Boolean.parseBoolean(customerDTO.getGender()));

        CustomerType customerType = new CustomerType();
        customerType.setId(customerDTO.getCustomerTypeDTO().getId());
        customer.setCustomerType(customerType);
        iCustomerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message",
                "Đã thêm thành công khách hàng: " + customer.getName());
        return "redirect:/customer/list";
    }

    @GetMapping("/update")
    public String goFormUpdateCustomer(@RequestParam int id, Model model) {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = iCustomerService.findCustomerById(id);
        BeanUtils.copyProperties(customer, customerDTO);
        customerDTO.setDateOfBirth(String.valueOf(customer.getDateOfBirth()));
        customerDTO.setGender(String.valueOf(customer.getGender()));

        CustomerTypeDTO customerTypeDTO = new CustomerTypeDTO();
        BeanUtils.copyProperties(customer.getCustomerType(), customerTypeDTO);
        customerDTO.setCustomerTypeDTO(customerTypeDTO);
        model.addAttribute("customerDTO", customerDTO);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute @Valid CustomerDTO customerDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customer.setDateOfBirth(LocalDate.parse(customerDTO.getDateOfBirth()));
        customer.setGender(Boolean.parseBoolean(customerDTO.getGender()));

        CustomerType customerType = new CustomerType();
        customerType.setId(customerDTO.getCustomerTypeDTO().getId());
        customer.setCustomerType(customerType);
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
