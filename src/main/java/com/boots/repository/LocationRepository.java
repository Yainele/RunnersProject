package com.boots.repository;

import com.boots.event.DefiniteLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<DefiniteLocation, Long> {
    DefiniteLocation findByLocationName(String LocationName);
}
