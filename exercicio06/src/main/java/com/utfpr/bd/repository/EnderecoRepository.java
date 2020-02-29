package com.utfpr.bd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utfpr.bd.domain.Endereco;
import com.utfpr.bd.domain.projecao.CidadeTotal;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	@Query("select e.cidade as cidade, count(e.cidade) as total from Endereco e group by e.cidade")
	List<CidadeTotal> findByCidadeTotal();
}
