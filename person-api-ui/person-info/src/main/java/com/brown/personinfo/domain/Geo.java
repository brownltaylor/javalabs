package com.brown.personinfo.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@CrossOrigin(origins="http://localhost:4200")
public class Geo {

    @Id
    @GeneratedValue
    @Column(name= "GEO_ID")
    private Long id;

    @Column(name="GEO_LAT")
    private Double lat;

    @Column(name="GEO_LNG")
    private Double lng;

    public Geo(){

    }

    public Geo(Long id, Double lat, Double lng){
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
