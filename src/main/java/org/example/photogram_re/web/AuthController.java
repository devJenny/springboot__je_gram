package org.example.photogram_re.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.photogram_re.domain.user.User;
import org.example.photogram_re.service.AuthService;
import org.example.photogram_re.web.dto.auth.SignupReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    public @ResponseBody String signup(@Valid SignupReqDto signupReqDto, BindingResult bindingResult) { // key=value (x-www-form-urlencoded)

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                log.info("error.getDefaultMessage() = " + error.getDefaultMessage());
            }
            return "오류남";
        } else {
            User join = authService.join(signupReqDto);
            log.info("join: {}", join.toString());

            return "auth/signin";
        }
    }

}
