package com.alternativo21.plataforma.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alternativo21.plataforma.model.Aluno;
import com.alternativo21.plataforma.model.Atividade;
import com.alternativo21.plataforma.model.Entrega;
import com.alternativo21.plataforma.repository.AlunoRepository;
import com.alternativo21.plataforma.repository.AtividadeRepository;
import com.alternativo21.plataforma.repository.EntregaRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Optional<Entrega> entregarAtividade(long atividadeId, long alunoId, Entrega entrega){
		Entrega entregaAtividade = entregaRepository.save(entrega);
		Optional<Atividade> atividade = atividadeRepository.findById(atividadeId);
		Optional<Aluno> aluno = alunoRepository.findById(alunoId);
		
		/*Se atividade e turma estiverem presentes, retorna um Optional com o valor , caso contrário, retorna um Optional vazio.*/
		if (aluno.isPresent() && atividade.isPresent()) {
			entregaAtividade.setAtividade(atividade.get());
			entregaAtividade.setAluno(aluno.get());
			return Optional.ofNullable(entregaRepository.save(entregaAtividade));
		} else {
			return Optional.empty();
		}
	}

}
