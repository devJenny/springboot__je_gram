package org.example.photogram_re.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.photogram_re.domain.user.User;
import org.example.photogram_re.service.AuthService;
import org.example.photogram_re.web.dto.auth.SignupReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller // 1. IoC 2. 파일을 리턴하는 controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    // 회원가입버튼 -> /auth/signup -> /auth/signin
    @PostMapping("/auth/signup")
    public String signup(SignupReqDto signupReqDto) { // key=value (x-www-form-urlencoded)
        User join = authService.join(signupReqDto);
        log.info("join: {}", join.toString());

        return "auth/signin";
    }

}
