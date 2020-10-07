package com.account.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorCodeException extends Exception {

    private int httpStatus;
    private String message;

}
