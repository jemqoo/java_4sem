package com.example.p10;

import org.springframework.stereotype.Component;

@Component("senior")
public class Senior implements Programmer{
    @Override
    public void doCoding() {
        System.out.println("I`m senior");
    }
}
