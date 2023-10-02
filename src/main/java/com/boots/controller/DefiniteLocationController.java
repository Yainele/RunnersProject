package com.boots.controller;

import com.boots.entity.User;
import com.boots.event.DefiniteLocation;
import com.boots.service.DefiniteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DefiniteLocationController {
    @Autowired
    private DefiniteLocationService DefiniteLocationService;

    @GetMapping("/event")
    public String getLocation(Long locationId, Model model) {
        model.addAttribute("allDefiniteLocations", DefiniteLocationService.getAllDefiniteLocations());
        return "event";
    }
    @PostMapping("/event/createLocation")
    public String createCustomLocation(@ModelAttribute("LocationForm") @Valid DefiniteLocation locationForm, BindingResult bindingResult, Model model) {
        model.addAttribute("LocationForm", DefiniteLocationService.createCustomLocation(locationForm));
        return "/event/createLocation";
    }

    @GetMapping("/event/createLocation")
    public String customLocation(Model model){
        model.addAttribute("LocationForm", new DefiniteLocation());
        return "/event/createLocation";
    }
}
