package com.brown.cryptonator;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {

    private String base;
    private String target;
    private double price;
    private double volume;
    private double change;
    private Market[] markets;
    private double timestamp;
    private boolean success;
    private String error;

    @Override
    public String toString() {
        return "ticker{" +
                "base='" + base + '\'' +
                ", target='" + target + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", change=" + change +
                ", markets=" + Arrays.toString(markets) +
                ", timestamp=" + timestamp +
                ", success=" + success +
                ", error='" + error + '\'' +
                '}';
    }

    public Ticker(){

    }


}
