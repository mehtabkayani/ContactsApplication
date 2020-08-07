package com.example.contactsapplication.controllers;

import com.example.contactsapplication.Models.User;
import com.example.contactsapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model, String keyword) {

        if (keyword != null) {
            model.addAttribute("userList", userService.searchUser(keyword));
        } else {

            model.addAttribute("userList", userService.getAllUsers());
        }

        return "index";
    }

    @GetMapping("/search")
    public String getSearch(String search, Model model) {
        System.out.println(search);
        List<User> searchedUsers = userService.searchUser(search);
        model.addAttribute("userList", searchedUsers);

        return "index";
    }

    @GetMapping("/add")
    public String addPage(@ModelAttribute User user, Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String add(User user, Model model, RedirectAttributes redirectAttributes) {

        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")

    public String edit(User user, Model model, RedirectAttributes redirectAttributes, @RequestParam (name = "active") String active) {

        if(active == "1"){
            user.setActive(true);
        }else if(active == "0"){
            user.setActive(false);
        }
        userService.editUser(user);


        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute(user);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(User user, Model model, RedirectAttributes redirectAttributes) {
        userService.deleteUser(user.getId());
        return "redirect:/";
    }
}
