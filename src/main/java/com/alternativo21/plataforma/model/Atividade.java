package com.alternativo21.plataforma.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "atividade")
public class Atividade {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull (message = "A atividade deve ter um título") private String titulo;
	
	@NotNull (message = "A atividade deve ter uma descrição") private String descricao;
	
	@ManyToMany(mappedBy = "atividade")
	@JsonIgnoreProperties({"atividade", "aluno", "professor"})
	private Set<Turma> turma = new HashSet<>();
	
	@OneToMany (mappedBy = "atividade")
	@JsonIgnoreProperties ("atividade")
	private Set<Entrega> entrega = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Turma> getTurma() {
		return turma;
	}

	public void setTurma(Set<Turma> turma) {
		this.turma = turma;
	}

	public Set<Entrega> getEntrega() {
		return entrega;
	}

	public void setEntrega(Set<Entrega> entrega) {
		this.entrega = entrega;
	}

	
}
