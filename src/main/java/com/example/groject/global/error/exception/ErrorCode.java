package com.example.groject.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
public enum ErrorCode {
    SAVE_IMAGE_FAILED(400, "image-400-1", "image save failed"),

    EXPIRED_TOKEN(401, "token-401-1", "expired token"),
    INVALID_TOKEN(401, "token-401-2", "Invalid token"),

    POST_NOT_FOUND(404, "post-404-1", "post not found"),
    USER_NOT_FOUND(404, "user-404-1", "user not found"),
    LIKE_NOT_FOUND(404, "like-404-1", "like not found"),

    PASSWORD_MISMATCH(409, "user-409-1", "password mismatch"),
    LIKE_EXISTS(409, "like-409-1", "like Exists");

    private final int status;
    private final String code;
    private final String message;
}
