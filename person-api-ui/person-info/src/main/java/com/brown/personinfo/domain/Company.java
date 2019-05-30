package com.brown.personinfo.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@CrossOrigin(origins="http://localhost:4200")
public class Company {

    @Id
    @GeneratedValue
    @Column(name="COMPANY_ID")
    private Long id;

    @Column(name="COMPANY_NAME")
    private String name;

    @Column(name= "COMPANY_CATCHPHRASE")
    private String catchPhrase;

    @Column(name="COMPANY_BS")
    private String bs;


    public Company(){

    }

    public Company(Long id, String name, String catchPhrase, String bs){
        this.id = id;
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
