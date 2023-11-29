package com.beautyfast.apibeautyfast.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Getter
@Setter
public class UserDTO {

    private String name;
    @CPF
    private String cpf;
    private BigDecimal salary;
    private String userPosition;
}
