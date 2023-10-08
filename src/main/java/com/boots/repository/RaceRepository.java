package com.boots.repository;

import com.boots.event.DefiniteLocation;
import com.boots.event.race.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
