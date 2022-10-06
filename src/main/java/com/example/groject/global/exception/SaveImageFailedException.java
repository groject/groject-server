package com.example.groject.global.exception;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;

public class SaveImageFailedException extends GrowException {
    public static final SaveImageFailedException EXCEPTION =
            new SaveImageFailedException();

    public SaveImageFailedException() {
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }
}
