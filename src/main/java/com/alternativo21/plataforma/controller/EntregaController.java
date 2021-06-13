package com.alternativo21.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternativo21.plataforma.model.Entrega;
import com.alternativo21.plataforma.repository.EntregaRepository;

@RestController
@RequestMapping ("/entregas")
public class EntregaController {
	@Autowired
	private EntregaRepository entregaRepository;
	

	
	@GetMapping
	ResponseEntity<List<Entrega>> todasEntregas(){
		return ResponseEntity.status(HttpStatus.OK).body(entregaRepository.findAll());
	}
	
	@PutMapping ("/entregar-atividade")
	ResponseEntity<Entrega> entregarAtividade(@RequestBody Entrega entrega ){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entregaRepository.save(entrega));
	}
}
