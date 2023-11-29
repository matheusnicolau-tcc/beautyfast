package com.beautyfast.apibeautyfast.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "tb_user")
public class User extends Person{

    @Id
    @Column(name = "user_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_salary",nullable = false)
    private BigDecimal salary;

    @Column(name = "user_position",nullable = false)
    private String userPosition;

}
