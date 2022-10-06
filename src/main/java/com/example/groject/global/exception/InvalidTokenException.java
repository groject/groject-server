package com.example.groject.global.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class InvalidTokenException extends GrowException {
    public static final InvalidTokenException EXCEPTION =
            new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
