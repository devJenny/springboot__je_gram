package org.example.photogram_re.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.photogram_re.domain.user.User;
import org.example.photogram_re.domain.user.UserRepository;
import org.example.photogram_re.web.dto.auth.SignupReqDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service // 1. IoC, 2. 트랜잭션 관리
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional // Write(insert, Update, Delete)
    public User join(SignupReqDto signupReqDto) {

        String rawPassword = signupReqDto.getPassword();
        String encPssword = bCryptPasswordEncoder.encode(rawPassword);
        signupReqDto.setPassword(encPssword);
        signupReqDto.setRole("ROLE_USER"); // 관리자 ROLE_ADMIN

        return userRepository.save(signupReqDto.toEntity());
    }

}
