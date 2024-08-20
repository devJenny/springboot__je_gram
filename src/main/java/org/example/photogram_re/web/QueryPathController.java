package org.example.photogram_re.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryPathController {

    @GetMapping("/chicken")
    public String chickenQuery(@RequestParam("type") String type) {
        return type + " 배달갑니다. (쿼리스트링)";
    }

    @GetMapping("/chicken/{type}")
    public String chickenPath(@PathVariable("type") String type) {
        return type + " 배달갑니다. (주소 변수 매핑)";
    }
}