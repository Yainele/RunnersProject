package com.boots.service;

import com.boots.event.Location;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class LocationService{
    @PersistenceContext
    private  EntityManager em;
    public  List<Location> locationList(Long idMin) {
        return em.createQuery("SELECT l FROM Location l WHERE l.id > :paramId", Location.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
