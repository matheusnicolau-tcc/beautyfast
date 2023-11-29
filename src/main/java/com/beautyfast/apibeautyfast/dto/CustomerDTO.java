package com.beautyfast.apibeautyfast.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class CustomerDTO {

    private String name;
    @CPF
    private String cpf;
    private String address;
}
