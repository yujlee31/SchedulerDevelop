package com.example.scheduler_develop.service;

import com.example.scheduler_develop.dto.ScheduleRequestDto;
import com.example.scheduler_develop.dto.ScheduleResponseDto;
import com.example.scheduler_develop.dto.ScheduleUpdateRequestDto;
import com.example.scheduler_develop.entity.Schedule;
import com.example.scheduler_develop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {
        return ScheduleResponseDto.toDto(findScheduleById(id));
    }

    private Schedule findScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 ID 값입니다.(없음)"));
    }

    public void deleteScheduleById(Long id) {
        findScheduleById(id);
        scheduleRepository.deleteById(id);
    }

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto.getWriterName(), scheduleRequestDto.getTitle(), scheduleRequestDto.getDescription());

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ScheduleResponseDto.toDto(savedSchedule);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto updateRequestDto) {
        Schedule schedule = findScheduleById(id);
        schedule.update(updateRequestDto.getTitle(), updateRequestDto.getDescription());
        return ScheduleResponseDto.toDto(schedule);
    }
}
