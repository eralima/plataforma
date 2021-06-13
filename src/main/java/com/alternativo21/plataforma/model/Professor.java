package com.alternativo21.plataforma.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "professor")
public class Professor extends Usuario{
	
	@ManyToMany 
	@JoinTable(name="professor_turma", joinColumns={@JoinColumn(name="professor_id")},
    inverseJoinColumns={@JoinColumn(name="turma_id")})
	private List<Turma> turma;

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
}
