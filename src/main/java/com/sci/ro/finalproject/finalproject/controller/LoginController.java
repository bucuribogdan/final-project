package com.sci.ro.finalproject.finalproject.controller;

import com.sci.ro.finalproject.finalproject.model.Users;
import com.sci.ro.finalproject.finalproject.service.SecurityService;
import com.sci.ro.finalproject.finalproject.service.UserService;
import com.sci.ro.finalproject.finalproject.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
        model.addAttribute("message", "You have been logged out successfully.");


        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new Users());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid Users user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        user.setRole("user");
        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());
        return "redirect:/login";
    }
}
