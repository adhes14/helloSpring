package com.adhemar.web;

import com.adhemar.dao.PeopleDao;
import com.adhemar.domains.People;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {
    @Autowired
    private PeopleDao peopleDao;
    
    @GetMapping("/")
    public String init(Model model) {
        Iterable<People> people = peopleDao.findAll();
        model.addAttribute("people", people);
        return "index";
    }
}
