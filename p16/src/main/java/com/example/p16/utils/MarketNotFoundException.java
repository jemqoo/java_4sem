package com.example.p16.utils;

public class MarketNotFoundException extends Exception {
    public MarketNotFoundException() {
        super("Market not found");
    }
}