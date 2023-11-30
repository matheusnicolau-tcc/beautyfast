package com.beautyfast.apibeautyfast.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LIstNotFindException extends BusinessException{
    public LIstNotFindException(String msg) {
        super(msg);
    }
}
