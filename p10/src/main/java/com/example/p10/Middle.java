package com.example.p10;

import org.springframework.stereotype.Component;

@Component("middle")
public class Middle implements Programmer{
    @Override
    public void doCoding() {
        System.out.println("I`m middle");
    }
}