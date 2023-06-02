package com.example.p17;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class P17Application {

	public static void main(String[] args) {
		System.out.println("im working");
		SpringApplication.run(P17Application.class, args);
		System.out.println("now here");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
