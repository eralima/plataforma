package com.alternativo21.plataforma.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario{
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"aluno", "professor", "atividade"})
	private Turma turma;
	
	@OneToMany (mappedBy = "aluno", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("aluno")
	private Set<Entrega> entrega = new HashSet<>();

	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Set<Entrega> getEntrega() {
		return entrega;
	}
	public void setEntrega(Set<Entrega> entrega) {
		this.entrega = entrega;
	}
}
