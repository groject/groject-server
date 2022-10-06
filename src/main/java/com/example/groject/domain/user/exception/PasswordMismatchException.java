package com.example.groject.domain.user.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class PasswordMismatchException extends GrowException {
    public static final PasswordMismatchException EXCEPTION =
            new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
