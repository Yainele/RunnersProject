package com.boots.service;

import com.boots.entity.User;
import com.boots.event.DefiniteLocation;
import com.boots.event.LocationStatus;
import com.boots.event.race.Race;
import com.boots.repository.LocationRepository;
import com.boots.repository.RaceRepository;
import com.boots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class RaceService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RaceRepository raceRepository;

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public boolean saveRace(Race race) {
        String userName = getCurrentUsername();
        if (userName == null){
            return false;
        }

        race.setUserId(userRepository.findByUsername(userName));


        return true;
    }
    /*
    private void updateRaceStatus(Race race){
        boolean isEpicDone = true;
        boolean isEpicNew = true;

        for (Subtask subtask : epic.getSubtasksInEpic()) {
            if(subtask.getStatus() != Status.DONE){
                isEpicDone = false;
                break;
            }
        }

        for (Subtask subtask : epic.getSubtasksInEpic()) {
            if(subtask.getStatus() != Status.NEW){
                isEpicNew = false;
                break;
            }
        }

        if(epic.getSubtasksInEpic().isEmpty()){
            epic.setStatus(Status.NEW);
        } else if (isEpicNew) {
            epic.setStatus(Status.NEW);
        } else if (isEpicDone) {
            epic.setStatus(Status.DONE);
        }
        else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }
     */



}
