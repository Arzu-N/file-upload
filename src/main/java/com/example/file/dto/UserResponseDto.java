package com.example.file.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String userName;
    private Integer age;
    private String photo;
    private List<FileResponseDto> files;

}
