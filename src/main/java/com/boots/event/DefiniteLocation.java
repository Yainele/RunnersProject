package com.boots.event;

import com.boots.entity.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_DefiniteLocation")
public class DefiniteLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long locationId;

    @Size(min = 2, max = 63, message = "От 2 до 63 знаков")
    private String locationName;

    @Size(min = 2, max = 250, message = "От 2 до 250 знаков")
    private String locationDescription;

    private Double longitude;

    private Double latitude;

    private LocationStatus locationStatus;

    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "locationImage")
    private byte[] locationImage;
    private Long userId;

    public void setUserId(User user) {
        if(user != null){
            this.userId = user.getId();
        }

    }

    public DefiniteLocation(Long locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    public DefiniteLocation() {
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public byte[] getLocationImage() {
        return locationImage;
    }

    public void setLocationImage(byte[] locationImage) {
        this.locationImage = locationImage;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocationStatus getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(LocationStatus locationStatus) {
        this.locationStatus = locationStatus;
    }
}
