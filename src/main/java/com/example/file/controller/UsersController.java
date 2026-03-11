package com.example.file.controller;

import com.example.file.dto.UserRequestDto;
import com.example.file.dto.UserResponseDto;
import com.example.file.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UsersController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void>addUser(@RequestPart MultipartFile photo, @RequestParam String userName,
                                       @RequestParam Integer age){
        var dto = new UserRequestDto(userName,age,photo);
        userService.addUser(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDto>>getUsers(){
        return ResponseEntity.ok(userService.getUser());
    }
}
