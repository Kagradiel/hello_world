package com.helloWorld.helloWorld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gen")
public class HelloWorldController {
	
	List<String> objetivos = new ArrayList<>();

	@GetMapping("/hello-world")
	public String helloworld() {
		return "Hello World!!!";
	}
	
	@GetMapping("/bsm")
	public List<String> getBSMs(){
		
		List<String> bsms = new ArrayList<>();
		
		bsms.add("Persistencia");
		bsms.add("Orientação ao detalhe");
		bsms.add("Comunicação");
		bsms.add("Orientação ao futuro");
		
		return bsms;
	}
	
	@GetMapping("/objetivos")
	public List<String> getObjetivos(){
		
		if (objetivos.isEmpty()) {
            objetivos.add("JWT em C#");
            objetivos.add("Exercitar React + typescript");
            objetivos.add("Migrar projeto .NET para Java"); 
        }
		
		return objetivos;
	}
	
	@PostMapping("/objetivos")
	public ResponseEntity<String> addObjetivo(@RequestBody String objetivo){
		objetivos.add(objetivo);
		return ResponseEntity.status(HttpStatus.CREATED).body("Objetivo adicionado");
	}

	
}

