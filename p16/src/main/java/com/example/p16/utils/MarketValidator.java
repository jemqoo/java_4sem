package com.example.p16.utils;

import com.example.p16.models.Market;
import org.springframework.stereotype.Component;

@Component
public class MarketValidator {
    public boolean validate(Market post) {
        if(post.getAddress()== null || post.getName() == null)
            return false;
        return true;
    }
}
