package com.utfpr.bd.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nomeCliente;
	
	@OneToMany(mappedBy="cliente")
    private Set<Pedido> pedidos;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getNomeCliente() {
		return nomeCliente;
	}

	public final void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public final Set<Pedido> getPedidos() {
		return pedidos;
	}

	public final void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
