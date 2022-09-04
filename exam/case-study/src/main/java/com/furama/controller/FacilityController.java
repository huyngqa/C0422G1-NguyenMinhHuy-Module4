package com.furama.controller;

import com.furama.model.facility.Facility;
import com.furama.service.IFacilityService;
import com.furama.service.IFacilityTypeService;
import com.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @GetMapping( value = {"","/list"})
    public String goListCustomer(@RequestParam(defaultValue = "") String keyword,
                                 @PageableDefault(size = 5) Pageable pageable,
                                 Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("facilityList", iFacilityService.findAllFacility(keyword, pageable));
        return "service/list";
    }

    @GetMapping("/create")
    public String goFormCreateCustomer(Model model) {
        model.addAttribute("rentTypeList", iRentTypeService.findAllRentType());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityType());
        model.addAttribute("facility", new Facility());
        return "service/add";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute Facility facility,
                                    RedirectAttributes redirectAttributes) {
        iFacilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("message",
                "Đã thêm thành công dịch vụ: " + facility.getName());
        return "redirect:/service/list";
    }

    @GetMapping("/update")
    public String goFormUpdateCustomer(@RequestParam int id, Model model) {
        model.addAttribute("rentTypeList", iRentTypeService.findAllRentType());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityType());
        model.addAttribute("facility", iFacilityService.findFacilityById(id));
        return "service/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Facility facility,
                                 RedirectAttributes redirectAttributes) {
        iFacilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("message",
                "Đã cập nhật thành công");
        return "redirect:/service/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iFacilityService.removeFacilityById(deleteId);
        redirectAttributes.addFlashAttribute("message",
                "Đã cập nhật thành công");
        return "redirect:/service/list";
    }
}
