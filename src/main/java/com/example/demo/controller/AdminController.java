package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;



    @RequestMapping(method = RequestMethod.GET)
    public String helloAdmin(){
        return "admin";
    }

    @GetMapping(value = "/admin")
    public String listUsers(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user1 = new User();
        model.addAttribute("user1", user1);
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        List<User> userList = userService.listUsers();
        model.addAttribute("listUsers", userList);
        return "admin";
    }
    @GetMapping(value = "/admin/usertables")
    public String viewUsers(Model model){
        List<User> userList = userService.listUsers();
        model.addAttribute("listUsers", userList);
        return "usertables";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id ){
        userService.removeUser(id);
        return "redirect:/admin";
    }
//
//    @GetMapping("/edit/{id}")
//    public String editUserForm(@PathVariable("id") Long id, Model model){
//        User user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "admin";
//    }
    @PostMapping("/edit")
    public String editUser(User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }

}
