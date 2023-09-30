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

    public void setId(Long id) {
        this.id = id;
    }
}
