package com.adhemar.web;

import java.util.ArrayList;

import com.adhemar.domains.Person;
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
        ArrayList<Person> people = peopleService.listPeople();
        model.addAttribute("people", people);
        return "index";
    }

    @GetMapping("/add")
    public String add(Person people) {
        return "modify";
    }

    @PostMapping("/save")
    public String save(Person people) {
        peopleService.save(people);
        return "redirect:/";
    }

    @GetMapping("/edit/{idPerson}")
    public String edit(Person people, Model model) {
        people = peopleService.findPerson(people);
        model.addAttribute("people", people);
        return "modify";
    }
}
