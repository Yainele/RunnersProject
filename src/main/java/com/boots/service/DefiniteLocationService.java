package com.boots.service;

import com.boots.event.DefiniteLocation;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class DefiniteLocationService {
    @PersistenceContext
    private  EntityManager em;
    public  List<DefiniteLocation> locationList(Long idMin) {
        return em.createQuery("SELECT l FROM DefiniteLocation l WHERE l.id > :paramId", DefiniteLocation.class)
                .setParameter("paramId", idMin).getResultList();
    }
    public List<DefiniteLocation> getAllDefiniteLocations(){
        return em.createQuery("select l from DefiniteLocation l", DefiniteLocation.class)
                .getResultList();
    }

}
