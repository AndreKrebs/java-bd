package com.utfpr.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utfpr.bd.domain.Contato;
import com.utfpr.bd.domain.Endereco;
import com.utfpr.bd.repository.ContatoRepository;
import com.utfpr.bd.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Transactional(readOnly = false)
	public void salvar(Endereco endereco, Contato contato) {
		enderecoRepository.save(endereco);
		contato.setEndereco(endereco);
		contatoRepository.save(contato);
	}
	
}
