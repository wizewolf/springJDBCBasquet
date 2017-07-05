package com.lab2.registroDeJugadores.controller;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ejb.access.EjbAccessException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class Controller {
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/prueba")
	public String prueba(@RequestParam(value="name", defaultValue="World") String name) {
		return "hola";
	}
	
}
