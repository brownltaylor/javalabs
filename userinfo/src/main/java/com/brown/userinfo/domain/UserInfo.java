package com.brown.userinfo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table
public class UserInfo {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name= "website")
    private String website;

    @Column(name="address")
    private Address address;

    @Column(name= "company")
    private Company company;

    public UserInfo(){

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
