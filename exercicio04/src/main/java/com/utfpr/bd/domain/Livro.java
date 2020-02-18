package com.utfpr.bd.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nomeLivro;
	
	@ManyToMany
	private Set<Autor> autores;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getNomeLivro() {
		return nomeLivro;
	}

	public final void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public final Set<Autor> getAutores() {
		return autores;
	}

	public final void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	
}
