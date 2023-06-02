package com.example.p16.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketResponse {
    private String message;

    public MarketResponse(String message) {
        this.message = message;
    }
}
