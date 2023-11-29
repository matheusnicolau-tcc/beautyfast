package com.beautyfast.apibeautyfast.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_schedules")
public class Schedules {

    @Id
    @Column(name = "schedule_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(name = "schedule_date", nullable = false)
    private LocalDateTime scheduleDate;

    @ManyToOne
    @JoinColumn(name = "user_id_fk", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "customer_id_fk", nullable = false)
    private  Customer customerId;
}


