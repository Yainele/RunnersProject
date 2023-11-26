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
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

   public Race receivedRace;



    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public Race saveRace(Race race) {
        if (race.getId() != null){
            return race;
        }
        String userName = getCurrentUsername();
        String startTime = race.getUserStartTime();
        race.setUserStartTime(refactorStartTime(startTime));
        race.setUserId(userRepository.findByUsername(userName));
        race.setRaceStatus(RaceStatus.WAITING_TO_START);
        raceRepository.save(race);
        receivedRace = race;
        return race;
    }

    public String refactorStartTime(String startTime) {
        StringBuilder stringBuilder = new StringBuilder(startTime);
        if (stringBuilder.length() != 0) {
            stringBuilder.replace(stringBuilder.length() - 6, stringBuilder.length() - 5, " ");
        }
        return stringBuilder.toString();
    }

    public String refactorStartTimeToBack(String startTime) {
        StringBuilder stringBuilder = new StringBuilder(startTime);
        if (stringBuilder.length() != 0) {
            stringBuilder.replace(stringBuilder.length() - 6, stringBuilder.length() - 5, "T");
        }
        return stringBuilder.toString();
    }

    public Race getRace(Long id) {
        return em.createQuery("SELECT r FROM Race r WHERE r.userId = :user_id", Race.class)
                .setParameter("user_id", id).getSingleResult();
    }

    public DefiniteLocation getLocationById(Race race) {
        return em.createQuery("SELECT r FROM DefiniteLocation r WHERE r.locationId = :location_id", DefiniteLocation.class)
                .setParameter("location_id", race.getLocationId()).getSingleResult();
    }

    public User getUserForRace() {
        String userName = getCurrentUsername();
        return userRepository.findByUsername(userName);
    }

    public Duration countdown(){
        String timeString = receivedRace.getUserStartTime();
        timeString = refactorStartTimeToBack(timeString);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(timeString, formatter);
        if(receivedRace.getRaceStatus() == RaceStatus.AWAITS_EXECUTION){
            return Duration.between(LocalDateTime.now().minusHours(14), receivedRace.getActualStartTime());
        }
        return Duration.between(LocalDateTime.now(), dateTime);
    }

    public boolean startRace(){
        RaceStatus raceStatus  = RaceStatus.AWAITS_EXECUTION;
            receivedRace.setActualStartTime(LocalDateTime.now());
            receivedRace.setRaceStatus(raceStatus);
            raceRepository.updateActualStartTime(receivedRace.getActualStartTime(), receivedRace.getId());
            raceRepository.updateRaceStatus(raceStatus,receivedRace.getId());
        return true;
    }

}
