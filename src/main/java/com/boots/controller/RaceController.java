package com.boots.controller;

import com.boots.event.race.Race;
import com.boots.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RaceController {
    @Autowired
    private RaceService raceService;

    @PostMapping("/save_race")
    String createRace(@ModelAttribute("race_form")Race race, Model model) {
        model.addAttribute("race_form", raceService.saveRace(race));
        return "save_race";
    }

    @GetMapping("/race")
    String getRace(Model model) {
        Race race = raceService.getRace();
        model.addAttribute("race_form_object", raceService.getRace());
        model.addAttribute("userForRace_form_object", raceService.getUserForRace());
        model.addAttribute("locationForRace_form_object", raceService.getLocationById(race));
        return "race";
    }

    @GetMapping("/countdown")
    @ResponseBody
    public String countdown() {
        Duration duration = raceService.countdown();

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        if(days == 0){
            return String.format("%d часов \n, %d минут \n, %d секунд",
                                    hours, minutes, seconds);
        }
        return String.format("%d дней \n, %d часов \n, %d минут \n, %d секунд",
                                 days, hours, minutes, seconds);
    }

    @PostMapping("/start_race")
    public String startRace(Model model) {
        model.addAttribute("start_race_form", raceService.startRace());
        return "redirect:/race";
    }

}
