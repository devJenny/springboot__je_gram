package org.example.photogram_re.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpController {

    @GetMapping("/get")
    public String get() {
        return "get 요청 완료";
    }

    @PostMapping("/post")
    public String post() {
        return "post 요청 완료";
    }

    @PutMapping("/put")
    public String put() {
        return "put 요청 완료";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "delete 요청 완료";
    }
}
