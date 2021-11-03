package com.spring.rest.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.spring.rest")
public class VidaDelEstudianteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VidaDelEstudianteApplication.class, args);
	}

}
