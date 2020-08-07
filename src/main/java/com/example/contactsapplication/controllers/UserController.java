package com.example.contactsapplication.Controllers;

import com.example.contactsapplication.Models.User;
import com.example.contactsapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList",userList);
        return "index";
    }


}
