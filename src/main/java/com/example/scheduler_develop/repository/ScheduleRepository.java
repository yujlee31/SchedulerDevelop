package com.example.scheduler_develop.repository;

import com.example.scheduler_develop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
