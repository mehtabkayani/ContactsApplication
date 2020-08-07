package com.example.contactsapplication.controllers;

import com.example.contactsapplication.Models.User;
import com.example.contactsapplication.Services.UserRepository;
import com.example.contactsapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    UserService userService;
    @PostMapping("/add")
    public User addNewUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/getall")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/id")
    public User getUserById(int id){
        return userService.getUserById(id);
    }
    @PutMapping("/edit")
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }
}
