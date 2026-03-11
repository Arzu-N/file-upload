package com.example.file.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class FileRequestDto {
    private String fileName;
    private MultipartFile url;
    private Long userId;


}
