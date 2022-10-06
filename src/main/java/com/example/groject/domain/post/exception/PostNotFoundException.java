package com.example.groject.domain.post.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class PostNotFoundException extends GrowException {
    public static final PostNotFoundException EXCEPTION =
            new PostNotFoundException();

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
