package com.brown.consumerrestdemo;

public class Value {

    private Long id;
    private String quote;

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }


    public Value(){

    }

    public Long getId(){
        return this.id;
    }

    public String getQuote(){
        return this.quote;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setQoute(String quote){
        this.quote = quote;
    }
}
