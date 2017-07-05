package com.lab2.registroDeJugadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class RegistroDeJugadoresApplication {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		SpringApplication.run(RegistroDeJugadoresApplication.class, args);
	}
}
