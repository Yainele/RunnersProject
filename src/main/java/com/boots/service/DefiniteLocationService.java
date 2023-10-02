package com.boots.service;

import com.boots.event.DefiniteLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class DefiniteLocationService {
    @PersistenceContext
    private  EntityManager em;


    public List<DefiniteLocation> getAllDefiniteLocations(){
        return em.createQuery("select l from DefiniteLocation l", DefiniteLocation.class)
                .getResultList();
    }

    public Object createCustomLocation(DefiniteLocation definiteLocation){
        if (definiteLocation == null){
            return false;
        }
        em.createQuery("INSERT INTO public.t_role(id," +
                " locationName," +
                "locationDescription," +
                "longitude," +
                "latitude," +
                "locationStatus", com.boots.event.DefiniteLocation.class)
                .setParameter("locationName",definiteLocation.getLocationName())
                .setParameter("locationDescription",definiteLocation.getLocationDescription())
                .setParameter("longitude",definiteLocation.getLongitude())
                .setParameter("latitude",definiteLocation.getLatitude())
                .setParameter("locationStatus",definiteLocation.getLocationStatus());

        return true;
    }

}
