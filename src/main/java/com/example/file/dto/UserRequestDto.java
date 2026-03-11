package com.example.file.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class UserRequestDto {
    private String userName;
    private Integer age;
    private MultipartFile photo;
}
