package org.example.photogram_re.web.dto.auth;

import lombok.Data;
import org.example.photogram_re.domain.user.User;


@Data // Getter, Setter
public class SignupReqDto {
    private String username;
    private String password;
    private String email;
    private String name;
    private String role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .role(role)
                .build();
    }
}
