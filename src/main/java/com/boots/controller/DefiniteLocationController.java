package com.boots.controller;

import com.boots.event.DefiniteLocation;
import com.boots.event.race.Race;
import com.boots.service.DefiniteLocationService;
import com.boots.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DefiniteLocationController {
    @Autowired
    private DefiniteLocationService DefiniteLocationService;

    @Autowired
    private RaceService raceService;


    @GetMapping("/creat_location")
    public String customLocation(Model model){
        DefiniteLocation definiteLocation = new DefiniteLocation();
        model.addAttribute("DefiniteLocation", definiteLocation);
        return "creat_location";
    }
    @GetMapping("/event")
    public String getLocation(Long locationId, Model model) {
        model.addAttribute("allDefiniteLocations", DefiniteLocationService.getAllDefiniteLocations());
        return "event";
    }
    @PostMapping("/creat_location/add_location")
    public String createCustomLocation(@ModelAttribute("LocationForm") @Valid DefiniteLocation locationForm, Model model) {
        model.addAttribute("DefiniteLocation", DefiniteLocationService.saveCustomLocation(locationForm));
        return "add_location";
    }
    @PostMapping("/race")
    String createRace(@ModelAttribute("race_form") @Valid Race race, Model model) {
        model.addAttribute("race_form", raceService.saveRace(race));
        return "race";
    }


}
