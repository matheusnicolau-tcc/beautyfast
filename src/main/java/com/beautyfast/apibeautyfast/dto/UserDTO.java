package com.beautyfast.apibeautyfast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Getter
@Setter
public class UserDTO {


    private Long userId;
    @JsonProperty("name")
    private String name;
    @CPF
    @JsonProperty("cpf")
    private String cpf;
    private BigDecimal salary;
    private String userPosition;
}
