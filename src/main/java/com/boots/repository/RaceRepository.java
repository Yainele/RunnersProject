package com.boots.repository;

import com.boots.event.race.Race;
import com.boots.event.race.RaceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface RaceRepository extends JpaRepository<Race, Long> {
    @Transactional
    @Modifying
    @Query("update Race r set r.raceStatus = ?1 where r.id = ?2")
    void updateRaceStatus(RaceStatus raceStatus, Long id);

    @Transactional
    @Modifying
    @Query("update Race r set r.actualStartTime = ?1 where r.id = ?2")
    void updateActualStartTime(LocalDateTime actualStartTime, Long id);

}
