package com.boots.controller;

import com.boots.event.interfaces.LocationInterface;
import com.boots.service.LocationService;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LocationController implements LocationInterface {
    @Autowired
    private LocationService locationService;
    @Override
    @GetMapping()
    public String getLocation(Long locationId, Model model) {
        model.addAttribute("allLocations", locationService.locationList(locationId));
        return "location";
    }

}
