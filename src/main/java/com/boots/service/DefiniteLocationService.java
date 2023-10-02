package com.boots.service;

import com.boots.event.DefiniteLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Object createCustomLocation(DefiniteLocation definiteLocation){
        if (definiteLocation == null){
            return false;
        }
        em.getTransaction().begin();
        em.persist(definiteLocation);
        em.flush();
        em.getTransaction().commit();
//        em.createQuery("INSERT into public.t_DefiniteLocation (id,locationName,locationDescription,longitude,latitude,locationStatus) VALUES (:id, :location_name, :locationDescriptio,:longitude, :latitude, :locationStatus)"
//                        )
//                .setParameter("id", definiteLocation.getId())
//                .setParameter("locationName",definiteLocation.getLocationName())
//                .setParameter("locationDescription",definiteLocation.getLocationDescription())
//                .setParameter("longitude",definiteLocation.getLongitude())
//                .setParameter("latitude",definiteLocation.getLatitude())
//                .setParameter("locationStatus",definiteLocation.getLocationStatus())
//                .executeUpdate();

        return true;
    }

}
