package com.sci.ro.finalproject.finalproject.controller;


import com.sci.ro.finalproject.finalproject.model.User;
import com.sci.ro.finalproject.finalproject.service.ProfileService;
import com.sci.ro.finalproject.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path ="/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public ModelAndView getProfileInformations(@RequestParam Integer id){
        ModelAndView pi = new ModelAndView();
        pi.setViewName("profile");
        pi.addObject("profile", profileService.getProfile(id));
        return pi;
    }

    @PostMapping("")
    public String profileSubmit(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "profile";
        }
        profileService.saveProfile(user);
        return "redirect:/profile";
    }
}
