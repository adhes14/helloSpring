package com.adhemar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {
    @GetMapping("/")
    public String init(Model model) {
        String message = "Hello world with Thymeleaf";
        model.addAttribute("message", message);
        return "index";
    }
}
