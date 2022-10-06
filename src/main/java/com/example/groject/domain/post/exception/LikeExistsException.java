package com.example.groject.domain.post.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class LikeExistsException extends GrowException {
    public static final LikeExistsException EXCEPTION =
            new LikeExistsException();

    public LikeExistsException() {
        super(ErrorCode.LIKE_EXISTS);
    }
}
