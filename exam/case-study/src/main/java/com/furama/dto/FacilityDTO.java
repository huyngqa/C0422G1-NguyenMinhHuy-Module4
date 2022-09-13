package com.furama.dto;

import com.furama.model.facility.FacilityType;
import com.furama.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Choice please!!!")
    @Pattern(regexp = "^([A-Z][a-z0-9]+)(\\s[A-Z0-9][a-z0-9]+)*$", message = "Please input error format!")
    private String name;
    private Double area;
    private Integer cost;
    @Min(value = 2, message = "no less than 2 people")
    @Max(value = 30, message = "no more than 30 people")
    private Integer maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    @Min(value = 1, message = "the lowest is the 1st floor")
    @Max(value = 50, message = "the highest floor is 50")
    private Integer numOfFloors;
    private String facilityFree;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDTO facilityDTO = (FacilityDTO) target;
        if(facilityDTO.cost < 0) {
            errors.rejectValue("cost", "create.cost", "price is not less than 0");
        }
    }
}
