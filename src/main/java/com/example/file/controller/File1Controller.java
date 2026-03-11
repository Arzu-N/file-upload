package com.example.file.controller;

import com.example.file.dto.FileRequestDto;
import com.example.file.service.FileService1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class File1Controller {

    private final FileService1 fileService1;

    @PostMapping
    public ResponseEntity<Void>addFile(@RequestParam String fileName,@RequestParam MultipartFile url,
                                       @RequestParam Long userId){
        FileRequestDto dto = new FileRequestDto(fileName, url, userId);
        fileService1.addFile(dto);
        return ResponseEntity.ok().build();
    }
}
