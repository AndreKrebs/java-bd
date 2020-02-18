package com.utfpr.bd.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Autor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nomeAutor;
	
	@ManyToMany
	@JoinTable(
	  name = "autor_livro", 
	  joinColumns = @JoinColumn(name = "autor_id"), 
	  inverseJoinColumns = @JoinColumn(name = "livro_id"))
	Set<Livro> livros;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getNomeAutor() {
		return nomeAutor;
	}

	public final void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public final Set<Livro> getLivros() {
		return livros;
	}

	public final void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
	
}
