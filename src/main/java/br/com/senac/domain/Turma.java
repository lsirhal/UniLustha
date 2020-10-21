package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "turmas")
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 7697943553676477457L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String ano_semestre;
	private String turno;
	
	@OneToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	public String getAno_semestre() {
		return ano_semestre;
	}

	public void setAno_semestre(String ano_semestre) {
		this.ano_semestre = ano_semestre;
	}

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}


}