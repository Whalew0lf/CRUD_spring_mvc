package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String printUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String openUserUpdatePage(@PathVariable("id") long id, User user) {

        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String oatePage(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        user.setId(id);
        return "redirect:/users";
    }
}
