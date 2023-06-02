package com.example.p16.utils;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("Product not found");
    }
}