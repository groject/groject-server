package com.example.groject.domain.user.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class UserNotFoundException extends GrowException {
    public static final UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
