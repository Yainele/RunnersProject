package com.boots.repository;

import com.boots.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.locationId = ?1 where u.id = ?2")
    void update(Long locationId, Long id);

    User findByUsername(String username);

}
