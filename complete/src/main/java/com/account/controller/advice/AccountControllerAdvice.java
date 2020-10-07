package com.account.controller.advice;

import com.account.domain.exception.ErrorCodeException;
import com.account.domain.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountControllerAdvice {

    @ExceptionHandler(value = ErrorCodeException.class)
    public ResponseEntity<?> errorCodeExceptionHandler(ErrorCodeException e) {
        return new ResponseEntity<Response>(new Response(e.getHttpStatus(), e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);

    }


}
