package com.adhemar.web;

import java.util.ArrayList;

import com.adhemar.domains.People;
import com.adhemar.service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InitController {
    @Autowired
    private PeopleService peopleService;
    
    @GetMapping("/")
    public String init(Model model) {
        ArrayList<People> people = peopleService.listPeople();
        model.addAttribute("people", people);
        return "index";
    }

    @GetMapping("/add")
    public String add(People people) {
        return "modify";
    }

    @PostMapping("/save")
    public String save(People people) {
        peopleService.save(people);
        return "redirect:/";
    }
}
