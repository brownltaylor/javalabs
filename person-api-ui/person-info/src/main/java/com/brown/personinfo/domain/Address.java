package com.brown.personinfo.domain;


import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column(name="ADDRESS_ID")
    private Long id;

    @Column(name="ADDRESS_STREET")
    private String street;

    @Column(name= "ADDRESS_SUITE")
    private String suite;

    @Column(name= "ADDRESS_CITY")
    private String city;

    @Column(name= "ADDRESS_ZIPCODE")
    private String zipcode;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name= "PERSON_GEO")
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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
