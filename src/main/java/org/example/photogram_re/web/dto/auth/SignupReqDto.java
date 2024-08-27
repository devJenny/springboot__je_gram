package org.example.photogram_re.web.dto.auth;

import lombok.Data;

@Data // Getter, Setter
public class SignupReqDto {
    private String username;
    private String password;
    private String email;
    private String name;
}
