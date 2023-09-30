package com.boots.event.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

public interface LocationInterface {
    public String getLocation(@PathVariable("locationId") Long locationId, Model model);

}
