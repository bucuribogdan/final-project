package com.sci.ro.finalproject.finalproject.controller;

import com.sci.ro.finalproject.finalproject.model.CustomTripsDetails;
import com.sci.ro.finalproject.finalproject.model.CustomUserDetails;
import com.sci.ro.finalproject.finalproject.model.Trip;
import com.sci.ro.finalproject.finalproject.model.Users;
import com.sci.ro.finalproject.finalproject.service.ProfileService;
import com.sci.ro.finalproject.finalproject.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;

@Controller
@RequestMapping(path = "/trips")
public class TripsController {

    private Long idedit;

    @Autowired
    TripService tripService;

    @GetMapping(path = "")
    public ModelAndView getAllTrips(){
        ModelAndView tr = new ModelAndView();
        tr.setViewName("trips");
        tr.addObject("trips", tripService.getAllTrips());
        return tr;
    }

    @GetMapping("/add")
    public String greetingForm(Model model) {
        model.addAttribute("trips", new Trip());
        return "add-trip";
    }

    @PostMapping("/add")
    public String tripSubmit(@Valid Trip trips, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-trip";
        }
            tripService.saveTrip(trips);
        return "redirect:/trips";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String removeTrip(@RequestParam Long id) {
        tripService.removeTripById(id);
        return "redirect:/trips";
    }

    @GetMapping(path = "/edit")
    public ModelAndView getTripInformations(@RequestParam Long id){
        ModelAndView tr = new ModelAndView();
        tr.setViewName("edit-trip");
        idedit=id;
        tr.addObject("trips", tripService.getTrip(id));
        return tr;
    }

    @PostMapping("/edit")
    public String tripEditSubmit(@Valid Trip trips, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "trips";
        }
        trips.setId(idedit);
        tripService.saveTrip(trips);
        return "redirect:/trips";
    }


}