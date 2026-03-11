package com.example.file.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String url;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    public File(String fileName, String url, Users user){
        this.fileName=fileName;
        this.url=url;
        this.user=user;
    }
}