package com.boots.controller;

import com.boots.service. DefiniteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DefiniteLocationController {
        @Autowired
        private DefiniteLocationService DefiniteLocationService;

        @GetMapping("/event")
        public String getLocation(Long locationId, Model model) {
            model.addAttribute("allDefiniteLocations", DefiniteLocationService.getAllDefiniteLocations());
            return "event";
    }
    @GetMapping("/event/{locationId}")
    public String  gtUser(@PathVariable("locationId") Long locationId, Model model) {
        model.addAttribute("allUsers", DefiniteLocationService.locationList(locationId));
        return "event";
    }

}
