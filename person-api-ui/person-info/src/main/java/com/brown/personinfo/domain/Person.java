package com.brown.personinfo.domain;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @Column(name= "PERSON_ID")
    private Long id;

    @Column(name= "PERSON_NAME")
    private String name;

    @Column(name= "PERSON_USERNAME")
    private String username;

    @Column(name= "PERSON_EMAIL")
    private String email;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name= "PERSON_ADDRESS")
    private Address address;


    @Column(name= "PERSON_PHONE")
    private String phone;

    @Column(name= "PERSON_WEBSITE")
    private String website;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name= "PERSON_COMPANY")
    private Company company;

    public Person(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
