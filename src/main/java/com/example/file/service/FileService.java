package com.example.file.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {
    String path = "C:\\File";
    File folder = new File(path);

    public void createFile(MultipartFile file) throws IOException {
        if (!folder.exists()){
            folder.mkdirs();
        }
        String paths=path + "/"+file.getOriginalFilename();
        File file1 = new File(paths);
        file.transferTo(file1);
    }
}