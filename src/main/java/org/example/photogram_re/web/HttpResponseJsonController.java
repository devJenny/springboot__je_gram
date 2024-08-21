package org.example.photogram_re.web;

import org.example.photogram_re.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpResponseJsonController {

    @GetMapping("/resp/json")
    public String respJson() {
        return "{\"username\":\"cos\"}";
    }

    @GetMapping("/resp/json/object")
    public User respJsonObject() {
        User user = new User();
        user.setUsername("홍길동");

        return user; // 1. MessageConverter 가 자동으로 JavaObejct를 Json으로 변경해서 통신을 통해 응답을 해준다
        // 2. @RestController 일 때만 MessageConverter가 작동함
    }
}
