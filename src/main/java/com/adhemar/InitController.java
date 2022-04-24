package com.adhemar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {
    @Value("${index.greetings}")
    private String greetings;

    @GetMapping("/")
    public String init(Model model) {
        String message = "Hello world with Thymeleaf";
        model.addAttribute("message", message);
        model.addAttribute("greetings", greetings);
        return "index";
    }
}
