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

import com.alternativo21.plataforma.model.Aluno;
import com.alternativo21.plataforma.model.Entrega;
import com.alternativo21.plataforma.repository.AlunoRepository;
import com.alternativo21.plataforma.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	ResponseEntity<List<Aluno>> todosAlunos(){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	ResponseEntity<List<Aluno>> alunosPeloNome(@PathVariable String nome){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	ResponseEntity<Aluno> inserirAluno(@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping("/entrega-atividade/aluno/{alunoId}/atividade/{atividadeId}")
	ResponseEntity<?> entregarAtividade (@PathVariable long alunoId, @PathVariable long atividadeId, @RequestBody Entrega entrega){
		Optional<Entrega> entregaAtividade = alunoService.entregarAtividade(atividadeId, alunoId, entrega);
		if (!entregaAtividade.isEmpty()) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(entregaAtividade.get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atividade ou aluno inválido");
		}
	}
}
