package com.example.contactsapplication.controllers;

import com.example.contactsapplication.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller()
public class UserController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    /*private ArrayList<User> loadUserTestData(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Mackan", "mackan@hotmail.com", true));
        users.add(new User("David", "david.stjernqvist@my.experis.se", true));
    }*/

}
