package com.example.file.service;

import com.example.file.dao.entity.File;
import com.example.file.dao.repository.FileRepository;
import com.example.file.dao.repository.UsersRepository;
import com.example.file.dto.FileRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService1 {
    private final FileRepository fileRepository;
    private final UsersRepository usersRepository;

    public void addFile(FileRequestDto dto)  {
        try{
        MultipartFile url = dto.getUrl();
        String originalFilename = UUID.randomUUID()+"_"+ url.getOriginalFilename();
        Path uploadPath = Paths.get("uploads");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path path = uploadPath.resolve(originalFilename);
        url.transferTo(path);

       fileRepository.save(new File(dto.getFileName(), path.toString(), usersRepository.findById(dto.getUserId()).
                orElseThrow(() -> new RuntimeException("User not found"))));
    }
catch(Exception e){
            throw new RuntimeException(e);
}}
}
