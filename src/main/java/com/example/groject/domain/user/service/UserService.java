package com.example.groject.domain.user.service;

import com.example.groject.domain.user.domain.User;
import com.example.groject.domain.user.domain.repository.UserRepository;
import com.example.groject.domain.user.exception.PasswordMismatchException;
import com.example.groject.domain.user.exception.UserNotFoundException;
import com.example.groject.domain.user.present.dto.SignInRequest;
import com.example.groject.domain.user.present.dto.TokenResponse;
import com.example.groject.domain.user.present.dto.SignUpRequest;
import com.example.groject.global.enums.Authority;
import com.example.groject.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void signup(SignUpRequest request) {
        userRepository.save(
                User.builder()
                        .name(request.getName())
                        .school(request.getSchool())
                        .number(request.getNumber())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .authority(Authority.USER.name())
                        .build()
        );
    }

    public TokenResponse login(SignInRequest request) {
        User user = userRepository.findByNumber(request.getNumber())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getNumber());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .authority(user.getAuthority())
                .build();
    }
}
