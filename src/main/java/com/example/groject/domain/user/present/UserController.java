package com.example.groject.domain.user.present;

import com.example.groject.domain.post.present.dto.PostResponse;
import com.example.groject.domain.user.present.dto.SignInRequest;
import com.example.groject.domain.user.present.dto.SignUpRequest;
import com.example.groject.domain.user.present.dto.TokenResponse;
import com.example.groject.domain.user.service.ProfileService;
import com.example.groject.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "유저", description = "유저 관련 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ProfileService profileService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest request) {
        userService.signup(request);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid SignInRequest request) {
        return userService.login(request);
    }

    @Operation(summary = "마이페이지 내가 쓴 글 최신순")
    @GetMapping("/time")
    public PostResponse mypageByTime() {
        return profileService.listMyPageByTime();
    }

    @Operation(summary = "마이페이지 내가 쓴 글 인기순")
    @GetMapping("/like")
    public PostResponse myPageByLike() {
        return profileService.ListMyPageByLike();
    }
}
