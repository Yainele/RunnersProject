package com.boots.controller;

import com.boots.event.race.Race;
import com.boots.event.race.RaceStatus;
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
    String getRace(@RequestParam Long id ,Model model) {
        Race race = raceService.getRace(id);
        model.addAttribute("race_form_object", race);
        model.addAttribute("userForRace_form_object", raceService.getUserForRace());
        model.addAttribute("locationForRace_form_object", raceService.getLocationById(race));
        return "race" + id;
    }

    @GetMapping("/countdown")
    @ResponseBody
    public String countdown() {
        Duration duration = raceService.countdown();

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        if(raceService.receivedRace.getRaceStatus() == RaceStatus.AWAITS_EXECUTION){
            return String.format("%d часов, %d минут, %d секунд",
                                      hours, minutes, seconds);
        }
            return String.format("%d дней ,%d часов, %d минут, %d секунд",
                                     days ,hours, minutes, seconds);
    }

    @PostMapping("/start_race")
    public String startRace(Model model) {
        model.addAttribute("start_race_form", raceService.startRace());
        return "redirect:/race";
    }

}
