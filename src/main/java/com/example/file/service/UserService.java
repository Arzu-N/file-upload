package com.example.file.service;

import com.example.file.dao.entity.Users;
import com.example.file.dao.repository.UsersRepository;
import com.example.file.dto.FileResponseDto;
import com.example.file.dto.UserRequestDto;
import com.example.file.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public void addUser(UserRequestDto dto) {
        try {
            MultipartFile photo = dto.getPhoto();
            String originalFilename = UUID.randomUUID()+"_"+photo.getOriginalFilename();
            Path uploads = Paths.get("uploads");
            if (!Files.exists(uploads)) {
                Files.createDirectories(uploads);
            }
            Path path = uploads.resolve(originalFilename);
            photo.transferTo(path);
            Users user = new Users();
            user.setUserName(dto.getUserName());
            user.setAge(dto.getAge());
            user.setPhoto(path.toString());
            usersRepository.save(user);}
        catch(Exception e){
            throw new RuntimeException(e);
        }}

            public List<UserResponseDto> getUser () {
            return usersRepository.findAll().stream().map(u->new UserResponseDto(u.getId(),u.getUserName(),
                    u.getAge(),u.getPhoto(),u.getFiles().stream().map(f->new FileResponseDto(f.getId(),f.getFileName()
            ,f.getUrl())).toList())).toList();
    }}
