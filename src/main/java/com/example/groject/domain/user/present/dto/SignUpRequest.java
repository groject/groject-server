package com.example.groject.domain.user.present.dto;

import com.example.groject.global.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class SignUpRequest {
    private String name;
    private String school;
    private String number;
    private String password;
}
