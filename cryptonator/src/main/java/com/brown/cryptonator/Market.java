package com.brown.cryptonator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Market {

    private String market;
    private double price;
    private double volume;

    public Market(){

    }
}
