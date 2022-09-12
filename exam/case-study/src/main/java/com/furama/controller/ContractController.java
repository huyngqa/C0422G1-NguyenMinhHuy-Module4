package com.furama.controller;

import com.furama.model.contract.Contract;
import com.furama.model.facility.Facility;
import com.furama.service.IContractService;
import com.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("")
    public String goContract() {
        return "contract/list";
    }

    @PostMapping("update")
    public String updateContract(@RequestParam Integer idContract, @RequestParam Integer selectFacility,
                                 RedirectAttributes redirectAttributes) {
        Facility facility = iFacilityService.findFacilityById(selectFacility);
        Contract contract = iContractService.getContractByID(idContract);
        contract.setFacility(facility);
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/contract";
    }
}
