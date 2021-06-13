package com.alternativo21.plataforma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alternativo21.plataforma.model.Atividade;
import com.alternativo21.plataforma.model.Professor;
import com.alternativo21.plataforma.repository.ProfessorRepository;
import com.alternativo21.plataforma.service.ProfessorService;

@RestController
@RequestMapping("/professores")
@CrossOrigin
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	ResponseEntity<List<Professor>> todosProfessores(){
		return ResponseEntity.status(HttpStatus.OK).body(professorRepository.findAll());
	}
	
	@PostMapping
	ResponseEntity<Professor> inserirProfessor(@RequestBody Professor professor){
		return ResponseEntity.status(HttpStatus.CREATED).body(professorRepository.save(professor));
	}
	
	//Método para professor em cada uma das turmas
	@PutMapping("/insercao-atividade/atividade/{atividadeId}/turma/{turmaId}")
	public ResponseEntity<?> adicionarAtividadeATurma(@PathVariable long atividadeId, @PathVariable long turmaId){
		Optional<Atividade> atividade = professorService.adicionarAtividadeATurma(atividadeId, turmaId);
		if (!atividade.isEmpty()) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(atividade.get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atividade ou turma inválido");
		}
	}
}
