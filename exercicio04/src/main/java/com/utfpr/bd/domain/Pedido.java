package com.utfpr.bd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String descricaoPedido;
	
	@ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getDescricaoPedido() {
		return descricaoPedido;
	}

	public final void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
	}

	public final Cliente getCliente() {
		return cliente;
	}

	public final void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
