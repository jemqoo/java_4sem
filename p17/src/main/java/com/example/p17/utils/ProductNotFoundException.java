package com.example.p17.utils;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("Product not found");
    }
}