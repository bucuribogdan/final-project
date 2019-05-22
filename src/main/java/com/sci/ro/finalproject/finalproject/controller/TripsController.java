package com.sci.ro.finalproject.finalproject.controller;

import com.sci.ro.finalproject.finalproject.model.CustomTripsDetails;
import com.sci.ro.finalproject.finalproject.model.CustomUserDetails;
import com.sci.ro.finalproject.finalproject.model.Trip;
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

@Controller
@RequestMapping(path = "/trips")
public class TripsController {

    private Long idedit;
    private String firstPhotoedit;
    private String secondPhotoedit;


    @Autowired
    TripService tripService;

    /**
     * This method display on the view all the saved trips through trips.html.
     */
    @GetMapping(path = "")
    public ModelAndView getAllTrips() {
        ModelAndView tr = new ModelAndView();
        tr.setViewName("trips");
        tr.addObject("trips", tripService.getAllTrips());
        return tr;
    }

    /**
     * This method display on the view the attributes of the trip object.
     *
     * @model is used to provide the attributes for the view
     */
    @GetMapping("/add")
    public String greetingForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "add-trip";
    }

    /**
     * This method saves the entered data if it is valid according to the validator.If the requirements are not *met, the voyage travel page will be returned with blank fields.
     *
     * @Trip this object is used to save new trip, which is automatically validated by @Valid annotation
     * @bindingResult is the argument used to validate the entered data
     */
    @PostMapping("/add")
    public String tripSubmit(@RequestParam("uploadFirstPhoto") MultipartFile firstImage, @RequestParam("uploadSecondPhoto")
            MultipartFile secondImage, @ModelAttribute("trip") @Valid Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "add-trip";
        }
        try {
            tripService.savePhoto(firstImage);
            tripService.savePhoto(secondImage);
        } catch (Exception e) {
            e.printStackTrace();
            return "add-trip";
        }
        trip.setFirstPhoto(firstImage.getOriginalFilename());
        trip.setSecondPhoto(secondImage.getOriginalFilename());
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    /**
     * This method deletes the trip based on the travel id.
     *
     * @param id is the travel id which will be deleted
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String removeTrip(@RequestParam Long id) {
        tripService.removeTripById(id);
        return "redirect:/trips";
    }

    /**
     * This method imports a specific ID trip and then displays it on the screen.
     *
     * @param id is the ID of the trip which will be imported and displayed on the screen
     */
    @GetMapping(path = "/edit")
    public ModelAndView getTripInformations(@RequestParam Long id) {
        ModelAndView tr = new ModelAndView();
        tr.setViewName("edit-trip");
        idedit = id;
        Trip currentTrip = tripService.getTrip(id);

        firstPhotoedit = currentTrip.getFirstPhoto();
        secondPhotoedit = currentTrip.getSecondPhoto();

        tr.addObject("trip", currentTrip);
        return tr;
    }

    /**
     * This method has the role of saving the imported trip and checking that the attributes of the Trip object *comply with the validator.
     *
     * @bindingResult is the argument used to validate the entered data
     * @Trip this object is used to save the changes, which is automatically validated by @Valid annotation
     */
    @PostMapping("/edit")
    public String tripEditSubmit(@Valid Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "trips";
        }
        trip.setFirstPhoto(firstPhotoedit);
        trip.setSecondPhoto(secondPhotoedit);
        trip.setId(idedit);
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }


}