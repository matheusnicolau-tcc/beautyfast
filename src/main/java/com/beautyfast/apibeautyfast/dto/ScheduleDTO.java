package com.beautyfast.apibeautyfast.dto;

import com.beautyfast.apibeautyfast.model.entity.Customer;
import com.beautyfast.apibeautyfast.model.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleDTO {

    private LocalDateTime scheduleDate;
    @NotNull
    private User user;
    @NotNull
    private Customer customer;
}
