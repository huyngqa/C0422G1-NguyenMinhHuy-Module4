package com.furama.controller;

import com.furama.dto.FacilityDTO;
import com.furama.model.facility.Facility;
import com.furama.service.IFacilityService;
import com.furama.service.IFacilityTypeService;
import com.furama.service.IRentTypeService;
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

@Controller
@RequestMapping("/service")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @ModelAttribute
    public void getModeAttribute(Model model) {
        model.addAttribute("rentTypeList", iRentTypeService.findAllRentType());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAllFacilityType());
    }

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
        model.addAttribute("facilityDTO", new FacilityDTO());
        return "service/add";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute @Valid FacilityDTO facilityDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        new FacilityDTO().validate(facilityDTO, bindingResult);
        if(bindingResult.hasErrors()) {
            return "service/add";
        }
        Facility facility =  new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);
        iFacilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("message",
                "Đã thêm thành công dịch vụ: " + facility.getName());
        return "redirect:/service/list";
    }

    @GetMapping("/update")
    public String goFormUpdateCustomer(@RequestParam int id, Model model) {
        Facility facility = iFacilityService.findFacilityById(id);
        FacilityDTO facilityDTO = new FacilityDTO();
        BeanUtils.copyProperties(facility, facilityDTO);
        model.addAttribute("facilityDTO", facilityDTO);
        return "service/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute @Valid FacilityDTO facilityDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new FacilityDTO().validate(facilityDTO, bindingResult);
        if(bindingResult.hasErrors()) {
            return "service/edit";
        }
        Facility facility =  new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);
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
