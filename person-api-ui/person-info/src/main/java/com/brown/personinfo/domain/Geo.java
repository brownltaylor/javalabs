package com.brown.personinfo.domain;

import javax.persistence.*;


@Entity
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
