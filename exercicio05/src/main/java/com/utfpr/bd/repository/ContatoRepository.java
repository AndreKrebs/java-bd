package com.utfpr.bd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.bd.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
