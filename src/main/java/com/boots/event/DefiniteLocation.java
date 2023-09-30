package com.boots.event;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_DefiniteLocation")
public class DefiniteLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min=2,max=63, message = "От 2 до 63 знаков")
    private String locationName;

    @Size(min=2,max=250, message = "От 2 до 250 знаков")
    private String locationDescription;

    @Lob
    @Column(name = "locationImage", columnDefinition="BYTEA")
    private byte[] locationImage;

    private Double longitude;

    private Double latitude;

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
