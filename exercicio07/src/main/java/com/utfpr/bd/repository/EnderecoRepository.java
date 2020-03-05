package com.utfpr.bd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.utfpr.bd.domain.Endereco;
import com.utfpr.bd.domain.projecao.CidadeTotal;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	@Query("select e.cidade as cidade, count(e.cidade) as total from Endereco e group by e.cidade")
	List<CidadeTotal> findByCidadeTotal();

	@Procedure("proc_endereco")
	String procedureEndereco(Long id);

	@Procedure
	String proc_endereco(long id);

	@Modifying
	@Query("update Endereco e set e.cidade = ?1 where e.id = ?2")
	int updateCidadeByld(String cidade, Long id);

	@Modifying
	@Query("delete from Endereco e where e.id =  ?1")
	int deleteEndereco(Long id);
}
