package com.beautyfast.apibeautyfast.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class DefaultError {

    private Instant timestamp;
    private Integer status;
    private String type;
    private String message;
    private String path;
}
