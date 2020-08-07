package com.example.contactsapplication.Controllers;

import com.example.contactsapplication.Models.User;
import com.example.contactsapplication.Services.UserRepository;
import com.example.contactsapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    UserService userService;


    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
