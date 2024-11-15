package com.example.scheduler_develop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writerName;
    private String email;
    private String password;

    public User() {}

    public User(String writerName, String email, String password) {
        this.writerName = writerName;
        this.email = email;
        this.password = password;
    }


}
