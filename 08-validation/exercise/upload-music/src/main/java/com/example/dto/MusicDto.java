package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @NotBlank(message = "không được để trống")
    @Size(max = 800, message = "Không được quá 8000 kí tự")
    private String name;
    @NotBlank(message = "không được để trống")
    @Size(max = 300, message = "Không được quá 300 kí tự")
    private String singer;
    @NotBlank(message = "không được để trống")
    @Size(max = 1000, message = "Không được quá 1000 kí tự")
    private String type;

    public MusicDto() {
    }

    public MusicDto(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (!musicDto.name.matches("^[\\w\\s]+$")) {
            errors.rejectValue("name",
                    "create.name",
                    "Tên bài hát không được chưa kí tự đặc biệt");
        }
        if (!musicDto.singer.matches("^[\\w\\s]+$")) {
            errors.rejectValue("singer",
                    "create.singer",
                    "Tên ca sĩ không được chưa kí tự đặc biệt");
        }
        if (!musicDto.type.matches("^[\\w\\s,]*$")) {
            errors.rejectValue("type",
                    "create.type",
                    "Thể loại không được chưa kí tự đặc biệt");
        }
    }
}
