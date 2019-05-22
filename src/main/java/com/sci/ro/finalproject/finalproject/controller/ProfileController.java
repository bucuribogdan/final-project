package com.sci.ro.finalproject.finalproject.controller;


import com.sci.ro.finalproject.finalproject.model.CustomUserDetails;
import com.sci.ro.finalproject.finalproject.model.Users;
import com.sci.ro.finalproject.finalproject.service.ProfileService;
import com.sci.ro.finalproject.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path ="/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     *This method takes the user's data according to the id and displays them in the profile.html file.
     *
     *@userDetails provides information about the authenticated user, more exactly the user ID.
     */
    @GetMapping(path = "")
    public ModelAndView getProfileInformations(@AuthenticationPrincipal CustomUserDetails userDetails){
        ModelAndView pi = new ModelAndView();
        pi.setViewName("profile");
        pi.addObject("profile", profileService.getProfile(userDetails.getId()));
        return pi;
    }

    /**
     *This method saves new user data if these are modified.
     *
     *@bindingResult is the argument used to validate the entered data
     *@userDetails provides information about the authenticated user, more exactly the user ID, user role and user password
     *@Users this object is used to save the changes, which is automatically validated by @Valid annotation
     */
    @PostMapping("")
    public String profileSubmit(@Valid Users profile, BindingResult bindingResult,@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "profile";
        }

        profile.setId(userDetails.getId());
        profile.setRole(userDetails.getRole());
        profile.setPassword(bCryptPasswordEncoder.encode(profile.getPassword()));
        profile.setPasswordConfirm(bCryptPasswordEncoder.encode(profile.getPasswordConfirm()));
        profileService.saveProfile(profile);
        return "redirect:/profile";
    }

}
