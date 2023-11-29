package com.beautyfast.apibeautyfast.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ScheduleDTO {

    private LocalDate scheduleDate;
    private Long userId;
    private Long customerId;
}
