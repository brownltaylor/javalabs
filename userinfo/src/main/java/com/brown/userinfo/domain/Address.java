package com.brown.userinfo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;


@Entity
@Table
public class Address {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="street")
    private String street;

    @Column(name= "suite")
    private String suite;

    @Column(name= "city")
    private String city;

    @Column(name= "zipcode")
    private String zipcode;

    @Column(name= "geo")
    private Geo geo;

    public Address(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
