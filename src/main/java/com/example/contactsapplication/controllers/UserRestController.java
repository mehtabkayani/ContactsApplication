package com.example.contactsapplication.Controllers;

import com.example.contactsapplication.Models.User;
import com.example.contactsapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/id")
    public User getUserById(int id) {

        return userService.getUserById(id);
    }

    @PutMapping("/edit/{id}")
    public User editUser(@RequestBody User user1, @PathVariable Integer id) {
        user1.setId(id);
        return userService.editUser(user1);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
