package com.boots.service;

import com.boots.entity.Role;
import com.boots.entity.User;
import com.boots.event.DefiniteLocation;
import com.boots.event.LocationStatus;
import com.boots.repository.LocationRepository;
import com.boots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.sql.Driver;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class DefiniteLocationService{
    @PersistenceContext
    private  EntityManager em;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserRepository userRepository;


    public List<DefiniteLocation> getAllDefiniteLocations(){
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username);
        return em.createQuery("select l from DefiniteLocation l where l.userId = :user_id or l.userId is null", DefiniteLocation.class)
                .setParameter("user_id", user.getId())
                .getResultList();
    }
    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    public boolean saveCustomLocation(DefiniteLocation definiteLocation) {
        String userName = getCurrentUsername();
        if (userName == null){
            return false;
        }
        User user = userRepository.findByUsername(userName);
        definiteLocation.setLocationStatus(LocationStatus.USER_LOCATION);
        definiteLocation.setLocationImage(null);
        definiteLocation.setUserId(user);
        user.setLocationId(definiteLocation);
        locationRepository.save(definiteLocation);
        userRepository.update(definiteLocation.getLocationId(), user.getId());
        return true;
    }

}
