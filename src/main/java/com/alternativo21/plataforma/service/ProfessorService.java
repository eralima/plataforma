package com.alternativo21.plataforma.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alternativo21.plataforma.model.Atividade;
import com.alternativo21.plataforma.model.Turma;
import com.alternativo21.plataforma.repository.AtividadeRepository;
import com.alternativo21.plataforma.repository.TurmaRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public Optional<Atividade> adicionarAtividadeATurma(long atividadeId, long turmaId){
		
		Optional<Atividade> atividade = atividadeRepository.findById(atividadeId);
		Optional<Turma> turma = turmaRepository.findById(turmaId);
		
		/*Se atividade e turma estiverem presentes, retorna um Optional com o valor , caso contrário, retorna um Optional vazio.*/
		if (atividade.isPresent() && turma.isPresent()) {
			turma.get().getAtividade().add(atividade.get());
			return Optional.ofNullable(atividadeRepository.save(atividade.get()));
			
		} else {
			return Optional.empty();
		}
		
	}

}
