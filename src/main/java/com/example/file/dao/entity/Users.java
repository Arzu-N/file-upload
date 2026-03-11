package com.example.file.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private Integer age;
private String photo;
    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL,orphanRemoval = true)
    private List<File>files;
}
