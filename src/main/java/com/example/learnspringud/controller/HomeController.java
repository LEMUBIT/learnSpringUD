package com.example.learnspringud.controller;

import com.example.learnspringud.NameForm;
import com.example.learnspringud.service.NameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private NameService nameService;

    public HomeController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/home")
    public String getHome(@ModelAttribute("newName") NameForm nameForm, Model model) {
        //var list = List.of("Java","C++","C#","Scala");

        var list = nameService.getNames();
        model.addAttribute("welcomeMsg", "Hey There!");
        model.addAttribute("names", list);
        return "Home";
    }

    @PostMapping("/home")
    public String addName(@ModelAttribute("newName") NameForm nameForm, Model model) {
        model.addAttribute("welcomeMsg", "Hey There!");
        nameService.addName(nameForm.getNametext());
        model.addAttribute("names", nameService.getNames());
        nameForm.setNametext("");
        return "Home";
    }
}
