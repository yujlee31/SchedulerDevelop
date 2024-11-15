package com.example.scheduler_develop.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private final Long userId;
    private final String title;
    private final String description;

    public ScheduleRequestDto(Long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }
}
