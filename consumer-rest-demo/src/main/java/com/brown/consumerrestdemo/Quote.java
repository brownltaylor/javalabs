package com.brown.consumerrestdemo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
public class Quote {

    private String type;
    private Value value;

    @JsonIgnoreProperties (ignoreUnknown = true)
    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }



    public Quote() {

    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public Value getValue(){
        return value;
    }
    public void setValue(Value value){
        this.value = value;

    }




}

