package com.adhemar.web;

import java.util.ArrayList;

import javax.validation.Valid;

import com.adhemar.domains.Person;
import com.adhemar.service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String add(Person person) {
        return "modify";
    }

    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors) {
        if(errors.hasErrors()) {
            return "modify";
        }
        peopleService.save(person);
        return "redirect:/";
    }

    @GetMapping("/edit/{idPerson}")
    public String edit(Person person, Model model) {
        person = peopleService.findPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }
    
    @GetMapping("/delete")
    public String delete(Person person) {
        peopleService.delete(person);
        return "redirect:/";
    }
}
