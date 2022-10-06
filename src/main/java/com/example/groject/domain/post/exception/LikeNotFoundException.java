package com.example.groject.domain.post.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class LikeNotFoundException extends GrowException {
    public static final LikeExistsException EXCEPTION =
            new LikeExistsException();

    public LikeNotFoundException() {
        super(ErrorCode.LIKE_NOT_FOUND);
    }
}
