package org.example.photogram_re.web;

import lombok.extern.slf4j.Slf4j;
import org.example.photogram_re.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HttpBodyController {

    @PostMapping("/body1")
    public String xwwwformurlencoded(@RequestParam("username") String username) {
        log.info("username: {}", username);
        return "key=value 전송옴";

    }

    @PostMapping("/body2")
    public String plaintext(@RequestBody String data) {
        log.info("data: {}", data);
        return "text/plain 전송옴";

    }

    @PostMapping("/body3")
    public String applicationjson(@RequestBody String data) {
        log.info(data);
        return "json 전송옴";
    }

    @PostMapping("/body4")
    public String applicationjsonToObject(@RequestBody User user) {
        log.info("user: {}", user.getUsername());
        return "json 전송옴";
    }

}
