package com.utfpr.bd.domain.projecao;

import org.springframework.beans.factory.annotation.Value;

public interface NomeCidade {
	String getNome();

	@Value("#{(target.endereco.cidade)}")
	String getCidade();
}
