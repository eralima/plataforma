package com.alternativo21.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternativo21.plataforma.model.Atividade;
import com.alternativo21.plataforma.repository.AtividadeRepository;

@RestController
@RequestMapping("/atividades")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AtividadeController {
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping
	ResponseEntity<List<Atividade>> todasAtividades(){
		return ResponseEntity.status(HttpStatus.OK).body(atividadeRepository.findAll());
	}
	
	@PostMapping
	ResponseEntity<Atividade> inserirAtividade(@RequestBody Atividade atividade){
		return ResponseEntity.status(HttpStatus.CREATED).body(atividadeRepository.save(atividade));
	}
	

	

}
