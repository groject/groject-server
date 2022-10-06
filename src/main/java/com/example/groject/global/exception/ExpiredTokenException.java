package com.example.groject.global.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class ExpiredTokenException extends GrowException {
    public static final ExpiredTokenException EXCEPTION =
            new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
