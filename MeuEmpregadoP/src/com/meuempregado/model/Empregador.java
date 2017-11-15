package com.meuempregado.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_empregador")
public class Empregador implements Serializable {

	private static final long serialVersionUID = -948306379906384070L;
	
	
	private Long id;
	private String nome;

	public Empregador() {
	
	}

	public Empregador(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
