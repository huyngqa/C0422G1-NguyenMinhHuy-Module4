package com.furama.dto;

import com.furama.annotation.Age18;
import com.furama.annotation.DateValid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO {
    private Integer id;
    @NotBlank(message = "Choice please!!!")
    @Pattern(regexp = "[A-Za-z ]+", message = "Please input error format!")
    private String name;
    @DateValid(message = "Input date no valid")
    @Age18(message = "Under 18 years old")
    private String dateOfBirth;
    @NotBlank(message = "Choice please!!!")
    @Pattern(regexp = "^(\\d{9}|\\d{12})$", message = "Please input error format! Example: " +
            "XXXXXXXXX or XXXXXXXXXXXX. X: (0-9)")
    private String idCard;
    @NotBlank(message = "Choice please!!!")
    @Pattern(regexp = "^((090|091)\\d{7})|((\\(84\\)\\+)(90)\\d{7})|((\\(84\\)\\+)(91)\\d{7})$",
    message = "\"Please input error format! Example: \" +\n" +
            "                        \"090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. X: (0-9)\"")
    private String phone;
    @NotBlank(message = "Choice please!!!")
    @Email(message = "ex: huynguyen@gmail.com")
    private String email;
    @NotBlank(message = "Choice please!!!")
    private String address;
}
