package com.alternativo21.plataforma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alternativo21.plataforma.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	public List<Aluno> findAllByNomeContainingIgnoreCase(String nome);

}
