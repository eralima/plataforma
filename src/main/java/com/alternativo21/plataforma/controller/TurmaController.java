package com.alternativo21.plataforma.controller;

import java.util.List;

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
import com.alternativo21.plataforma.model.Turma;
import com.alternativo21.plataforma.repository.AtividadeRepository;
import com.alternativo21.plataforma.repository.TurmaRepository;

@RestController
@RequestMapping("/turmas")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TurmaController {
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping
	ResponseEntity<List<Turma>> todosAlunos(){
		return ResponseEntity.status(HttpStatus.OK).body(turmaRepository.findAll());
	}
	
	@PostMapping
	ResponseEntity<Turma> inserirAluno(@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
	}
	
	//Método para inserir as atividades em cada uma das turmas
	@PutMapping("/{turmaId}/atividade/{atividadeId}")
	ResponseEntity<Atividade> adicionarAtividadesATurma(@PathVariable long  turmaId, @PathVariable long atividadeId) {
	Atividade atividade = atividadeRepository.findById(atividadeId).get();
	Turma turma = turmaRepository.findById(turmaId).get();
		
	//Adicionando a atividade na lista de atividades da turma
	turma.getAtividade().add(atividade);
		
	return ResponseEntity.status(HttpStatus.CREATED).body(atividadeRepository.save(atividade));
	}
	
	

}
