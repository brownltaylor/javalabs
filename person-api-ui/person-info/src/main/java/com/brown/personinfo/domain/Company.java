package com.brown.personinfo.domain;

import javax.persistence.*;

@Entity
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
