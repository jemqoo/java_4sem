package com.example.p10;

import org.springframework.stereotype.Component;

@Component
public class Someone {
    private final Programmer programmer;

    public Someone(Programmer  programmer) {
        this.programmer = programmer;
    }

    public void doCoding(){
        System.out.println("I'm coding");
    }
}