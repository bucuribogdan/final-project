package com.sci.ro.finalproject.finalproject.controller;

import com.sci.ro.finalproject.finalproject.model.Trip;
import com.sci.ro.finalproject.finalproject.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/trips")
public class TripsController {
    @Autowired
    TripService tripService;

    @GetMapping(path = "")
    public ModelAndView getTrips(){
        ModelAndView trip = new ModelAndView();
        trip.setViewName("trips");
        trip.addObject("profile", tripService.getAllTrips());
        return trip;
    }

    @GetMapping("/add")
    public String greetingForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "add-trip";
    }

    @PostMapping("/add")
    public String tripSubmit(@Valid Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-trip";
        }
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

}