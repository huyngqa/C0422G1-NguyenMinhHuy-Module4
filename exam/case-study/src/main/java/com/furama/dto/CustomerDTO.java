package com.furama.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends PersonDTO{
    @NotBlank(message = "Choose, please!!!")
    private String gender;
    private CustomerTypeDTO customerTypeDTO;
}
