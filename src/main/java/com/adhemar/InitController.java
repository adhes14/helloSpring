package com.adhemar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
    @GetMapping("/")
    public String init() {
        return "Hello world with Spring Boot";
    }
}
