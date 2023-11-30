package com.beautyfast.apibeautyfast.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleDTO {

    private LocalDateTime scheduleDate;
    private Long userId;
    private Long customerId;
}
