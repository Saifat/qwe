package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//public class EditController {
//
//    @Autowired
//    UserService userService;
//
//    @GetMapping("admin/{id}")
//    public String editUserForm(@PathVariable("id") Long id, Model model){
//        User user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "admin";
//    }
//    @PostMapping("/admin")
//    public String editUser(User user){
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//}
