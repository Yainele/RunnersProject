package com.boots.controller;

import com.boots.event.race.Race;
import com.boots.service.DefiniteLocationService;
import com.boots.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class RaceController {
    @Autowired
    private RaceService raceService;
    @PostMapping("/create_race")
    String createRace(@ModelAttribute("race_form")Race race, Model model) {
        model.addAttribute("race_form", raceService.saveRace(race));
        return "race";
    }
    @GetMapping("/race")
    String getRace(Race race, Model model) {
        model.addAttribute("race_form_object", raceService.getRace());
        model.addAttribute("userForRace_form_object", raceService.getUserForRace());
        model.addAttribute("locationForRace_form_object", raceService.getLocationById(race));
        return "race";
    }


}
