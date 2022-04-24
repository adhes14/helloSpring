package com.adhemar;

import com.adhemar.domains.People;
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
        People person = new People();
        person.setFirstName("Juan");
        person.setLastName("Perez");
        person.setEmail("jperez@mail.com");
        person.setPhone("852147963");
        model.addAttribute("message", message);
        model.addAttribute("greetings", greetings);
        model.addAttribute("person", person);
        return "index";
    }
}
