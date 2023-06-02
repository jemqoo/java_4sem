package com.example.p10;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String @NotNull [] args) {
		ApplicationContext context =  new AnnotationConfigApplicationContext(BeanConfig.class);

		try {
			Programmer programmer = (Programmer) context.getBean(args[0], Programmer.class);
			programmer.doCoding();
		} catch (IndexOutOfBoundsException e) {
		e.printStackTrace();
		System.err.println("Expected 1 command line argument, found 0!");
	}

	}

}
