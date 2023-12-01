package com.beautyfast.apibeautyfast.exceptionhandler;

import com.beautyfast.apibeautyfast.model.exception.CpfAlreadyExistsException;
import com.beautyfast.apibeautyfast.model.exception.LIstNotFindException;
import com.beautyfast.apibeautyfast.model.exception.SchedulesNotFindException;
import com.beautyfast.apibeautyfast.model.exception.UserNotFindException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFindException.class)
    public ResponseEntity<DefaultError> userNotFind(UserNotFindException e, HttpServletRequest request) {
        var err = new DefaultError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setType("UserNotFindException");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(CpfAlreadyExistsException.class)
    public ResponseEntity<DefaultError> cpfAlreadyExists(CpfAlreadyExistsException e, HttpServletRequest request) {
        var err = new DefaultError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setType("CpfAlreadyExistsException");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(LIstNotFindException.class)
    public ResponseEntity<DefaultError> ListNotFind(LIstNotFindException e, HttpServletRequest request) {
        var err = new DefaultError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setType("LIstNotFindException");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(SchedulesNotFindException.class)
    public ResponseEntity<DefaultError> ListNotFind(SchedulesNotFindException e, HttpServletRequest request) {
        var err = new DefaultError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setType("SchedulesNotFindException");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
