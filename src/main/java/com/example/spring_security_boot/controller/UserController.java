package com.example.spring_security_boot.controller;

import com.example.spring_security_boot.model.User;
import com.example.spring_security_boot.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService UserDetailsService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "/home";
    }

    @GetMapping("/403")
    public String showErrorAccess() {
        return "/NoAccess";
    }

    @GetMapping("/register")
    public ModelAndView showFormLogin() {
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView login(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("user", new User());
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (UserDetailsService.save(user) == true) {
                modelAndView.addObject("message", "Register success");
                modelAndView.setViewName("/login");
            } else {
                modelAndView.addObject("message", "Register fail");
            }
        }
        return modelAndView;
    }
}
