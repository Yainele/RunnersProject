package com.boots.service;

import com.boots.entity.User;
import com.boots.event.DefiniteLocation;
import com.boots.event.LocationStatus;
import com.boots.repository.LocationRepository;
import com.boots.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
        locationRepository.save(definiteLocation);
        return true;
    }

}
