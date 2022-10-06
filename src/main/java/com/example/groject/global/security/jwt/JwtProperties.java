package com.example.groject.global.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final String secretKey;
    private final Long accessExp;
    private final Long refreshExp;
    private final String header;
    private final String prefix;
}
