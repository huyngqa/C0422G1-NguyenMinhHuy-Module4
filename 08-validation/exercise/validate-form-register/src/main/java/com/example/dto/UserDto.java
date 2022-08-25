package com.example.dto;

import com.example.annotation.Age;
import com.example.annotation.AgeEmpty;
import com.example.annotation.Name;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserDto {

    @Name(message = "Vui lòng nhập đúng định dạng!!! (ex:Nguyễn Văn)")
    private String firstName;
    @Name(message = "Vui lòng nhập đúng định dạng!!! (ex:Huy)")
    private String lastName;
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải là 10 số")
    private String phone;
    @AgeEmpty
    @Age
    private String birthDay;
    @Email(message = "ví dụ: abc@gmail.com")
    private String email;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
