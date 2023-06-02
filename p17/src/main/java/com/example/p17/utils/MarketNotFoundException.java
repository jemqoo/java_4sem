package com.example.p17.utils;

public class MarketNotFoundException extends Exception {
    public MarketNotFoundException() {
        super("Market not found");
    }
}