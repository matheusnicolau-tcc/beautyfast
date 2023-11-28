package com.beautyfast.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "tb_customer")
public class Customer extends Person{

    @Id
    @Column(nullable = false )
    private UUID customerId;


}
