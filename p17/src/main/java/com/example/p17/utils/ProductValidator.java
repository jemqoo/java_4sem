package com.example.p17.utils;

import com.example.p17.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    public boolean validate(Product product) {
        if(product.getName()== null || product.getPrice() == 0)
            return false;
        return true;
    }
}
