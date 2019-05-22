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
import org.springframework.web.bind.annotation.ModelAttribute;
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


    /**
     * In this method is it checked if the login data, username and password, are valid.
     *
     * @param model the bridge between view and controller
     * @param error verify if the password and the username are correct
     * @param logout
     * @return
     */
    @GetMapping("")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
        model.addAttribute("message", "You have been logged out successfully.");


        return "login";
    }

    /**
     * In aceasta metoda se face legatura dintre baza de date si fisierul registration.html.
     *
     * @param model the bridge between view and controller
     * @return fisierul registration.html
     */

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new Users());

        return "registration";
    }

    /**
     * Aceasta metoda verifica daca datele introduse sunt conform cerintelor impuse de catre administrator:
     * numele de utilizator sa fie unic, numarul de telefon sa fie format din 10 cifre, parola sa fie de minim
     * 10 caractere.
     *
     * @param user este obiectul in care sunt salvate datele introduse
     * @param bindingResult  verifica daca cerintele sunt indeplinite
     * @return pagina de logare daca totul a decurs normal si cerintele au fost respectate
     * @return aceeasi pagina daca conditiile nu au fost indeplinite
     */
    @PostMapping("/registration")
    public String registration(@Valid Users user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "registration";
        }
        user.setRole("user");
        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());
        return "redirect:/login";
    }
}
