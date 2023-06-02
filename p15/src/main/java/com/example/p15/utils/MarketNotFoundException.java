package com.example.p15.utils;

public class MarketNotFoundException extends Exception {
    public MarketNotFoundException() {
        super("Market not found");
    }
}