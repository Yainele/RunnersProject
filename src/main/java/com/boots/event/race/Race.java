package com.boots.event.race;

import com.boots.entity.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_Race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private RaceStatus raceStatus;

    private Instant userStartTime;

    private Long userId;

    private Long locationId;

    public Race(Long id, RaceStatus raceStatus) {
        this.id = id;
        this.raceStatus = RaceStatus.AWAITS_EXECUTION;
    }

    public Race() {
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
    public void setUserId(User user) {
        if(user != null){
            this.userId = user.getId();
        }

    }

    public Long getUserId() {
        return userId;
    }

    public Instant getUserStartTime() {
        return userStartTime;
    }

    public void setUserStartTime(Instant userStartTime) {
        this.userStartTime = userStartTime;
    }

    public RaceStatus getRaceStatus() {
        return raceStatus;
    }

    public void setRaceStatus(RaceStatus raceStatus) {
        this.raceStatus = raceStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
