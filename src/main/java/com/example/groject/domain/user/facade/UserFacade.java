package com.example.groject.domain.user.facade;

import com.example.groject.domain.user.domain.User;
import com.example.groject.domain.user.domain.repository.UserRepository;
import com.example.groject.domain.user.exception.UserNotFoundException;
import com.example.groject.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public User getCurrentUser() {
        String number = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByNumber(number)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
