package com.example.scheduler_develop.dto;

import com.example.scheduler_develop.entity.User;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private final String writerName;
    private final String email;
    private final String password;

    public UserRequestDto(String writerName, String email, String password) {
        this.writerName = writerName;
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return new User(
                this.writerName,
                this.email,
                this.password
        );
    }
}
