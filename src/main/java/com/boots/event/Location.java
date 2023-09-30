package com.boots.event;
import com.boots.entity.Role;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "t_location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min=2,max=63, message = "От 2 до 63 знаков")
    private String locationName;

    @Size(min=2,max=250, message = "От 2 до 250 знаков")
    private String locationDescription;

    private Double longitude;
    private Double latitude;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
