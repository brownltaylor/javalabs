package com.brown.userinfo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
public class Geo {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name= "lat")
    private String lat;

    @Column(name= "lng")
    private String lng;

    public Geo(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
