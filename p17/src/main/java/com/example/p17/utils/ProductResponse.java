package com.example.p17.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private String message;

    public ProductResponse(String message) {
        this.message = message;
    }
}
