package org.example.photogram_re.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpRedirectionController {

    @GetMapping("/home")
    public String home() {
        // 1만줄 가정
        return "home";

    }

    @GetMapping("/away")
    public String away() {
        // 다른 코드
        return "redirect:/home";
    }
}
