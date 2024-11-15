package com.example.scheduler_develop.service;


import com.example.scheduler_develop.dto.UserRequestDto;
import com.example.scheduler_develop.dto.UserResponseDto;
import com.example.scheduler_develop.entity.User;
import com.example.scheduler_develop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User savedUser = userRepository.save(userRequestDto.toEntity());
        return UserResponseDto.toDto(savedUser);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다"));
    }

    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    @Transactional
    public void deleteUser(Long id) {
        findUserById(id);
        userRepository.deleteById(id);
    }
}
