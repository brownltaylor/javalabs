package com.brown.consumingrestlab;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geo {

    private float lat;
    private float lng;

    public Geo(){


    }

    public void setLat(float lat){
     this.lat = lat;
    }
    public float getLat(){
        return lat;
    }
    public void setLng(float lng){
        this.lng = lng;
    }
    public float getLng(){
        return lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
