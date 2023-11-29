package com.beautyfast.apibeautyfast.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person {

    @Column(name = "name")
    protected String name;

    @Column(name = "cpf")
    protected String cpf;
}
