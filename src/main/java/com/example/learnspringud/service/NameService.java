package com.example.learnspringud.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class NameService {
    private List<String> names;

//    public NameService() {
//        names = new ArrayList<>();
//    }

    @PostConstruct
    public void postConstruct() {
        names = new ArrayList<>();
    }


    public void addName(String name){
        names.add(name);
    }

    public List<String> getNames() {
        return names;
    }
}
