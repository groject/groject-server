package com.example.groject.domain.user.present.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInRequest {
    private String number;
    private String password;
}
