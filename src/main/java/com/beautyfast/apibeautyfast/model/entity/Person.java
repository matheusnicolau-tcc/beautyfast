package com.beautyfast.apibeautyfast.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String cpf;
}
