package com.example.groject.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GrowException extends RuntimeException{
    private final ErrorCode errorCode;
}
