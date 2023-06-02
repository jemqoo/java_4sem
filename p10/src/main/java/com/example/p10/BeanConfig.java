package com.example.p10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "junior")
    public Programmer junior() {
        return new Junior();
    }

    @Bean(name = "middle")
    public Programmer boxer(){
        return new Middle();
    }

    @Bean(name = "senior")
    public Programmer senior(){
        return new Senior();
    }
}