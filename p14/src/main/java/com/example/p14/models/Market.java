package com.example.p14.models;

import lombok.Data;

@Data
public class Market {
    private String address;
    private String name;

    public Market(String address, String name){
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
}
