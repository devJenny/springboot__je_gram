package org.example.photogram_re.service;

import lombok.RequiredArgsConstructor;
import org.example.photogram_re.domain.user.User;
import org.example.photogram_re.domain.user.UserRepository;
import org.example.photogram_re.web.dto.auth.SignupReqDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service // 1. IoC, 2. 트랜잭션 관리
public class AuthService {

    private final UserRepository userRepository;

    public User join(SignupReqDto signupReqDto) {
        return userRepository.save(signupReqDto.toEntity());
    }

}
