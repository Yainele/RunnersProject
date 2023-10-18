package com.boots.service;

import com.boots.entity.User;
import com.boots.event.DefiniteLocation;
import com.boots.event.race.Race;
import com.boots.event.race.RaceStatus;
import com.boots.repository.LocationRepository;
import com.boots.repository.RaceRepository;
import com.boots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class RaceService {

    @PersistenceContext
    private EntityManager em;

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
        String startTime = race.getUserStartTime();
        race.setUserStartTime(refactorStartTime(startTime));
        race.setUserId(userRepository.findByUsername(userName));
        race.setRaceStatus(RaceStatus.AWAITS_EXECUTION);
        raceRepository.save(race);

        return true;
    }
    public String refactorStartTime(String startTime){
        StringBuilder stringBuilder = new StringBuilder(startTime);
        if (stringBuilder.length() != 0) {
            stringBuilder.replace(stringBuilder.length() - 6, stringBuilder.length() - 5 , " ");
        }
        return stringBuilder.toString();
    }

     public Race getRace(){
         String userName = getCurrentUsername();
         User user = userRepository.findByUsername(userName);
         return em.createQuery("SELECT r FROM Race r WHERE r.userId = :user_id", Race.class)
                 .setParameter("user_id", user.getId()).getSingleResult();
     }

     public DefiniteLocation getLocationById(Race race){
         return em.createQuery("SELECT r FROM DefiniteLocation r WHERE r.locationId = :location_id", DefiniteLocation.class)
                 .setParameter("location_id", race.getLocationId()).getSingleResult();
     }

     public User getUserForRace(){
         String userName = getCurrentUsername();
         return userRepository.findByUsername(userName);
     }
/*
     public String refactorRaceStatus(RaceStatus raceStatus){
        switch (raceStatus){
            case AWAITS_EXECUTION:
                return "Ожидает завершения!";
            case NOT_FINISHED:
                return "Не финишировал!";
            case  FINISHED:
                return "Финишировал!";
            case  CANCELED:
                return "Отменен!";
            case MODERATED:
                return  "Находится на модерации!";
            default:
                return "Статус не определен!";

        }
     }

    /*, CANCELED, MODERATED, IN_LIMBO
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
