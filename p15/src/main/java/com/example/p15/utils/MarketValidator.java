package com.example.p15.utils;

import com.example.p15.models.Market;
import org.springframework.stereotype.Component;

@Component
public class MarketValidator {
    public boolean validate(Market post) {
        if(post.getAddress()== null || post.getName() == null)
            return false;
        return true;
    }
}
