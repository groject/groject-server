package com.example.groject.global.error;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class ExceptionHandler extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (GrowException e) {
            ErrorCode errorCode = e.getErrorCode();

            ErrorResponse errorResponse = new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());

            String errorResult = objectMapper.writeValueAsString(errorResponse);

            response.setStatus(errorResponse.getStatus());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(errorResult);
        }
    }
}
