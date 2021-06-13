package com.alternativo21.plataforma.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "turma")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull (message = "Informar a turma") private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio = new java.sql.Date(System.currentTimeMillis());
	
	@Temporal(TemporalType.DATE)
	private Date dataFinal = new java.sql.Date(System.currentTimeMillis());
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"turma"})
	private List<Aluno> aluno = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="turma_atividade", joinColumns={@JoinColumn(name="turma_id")},
    inverseJoinColumns={@JoinColumn(name = "atividade_id")})
	private Set<Atividade> atividade = new HashSet<>();
	
	@ManyToMany (mappedBy = "turma")
	@JsonIgnoreProperties({"turma"})
	private List<Professor> professor;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal; 
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

	public Set<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(Set<Atividade> atividade) {
		this.atividade = atividade;
	}

	public List<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}

	
}
