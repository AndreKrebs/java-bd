package com.utfpr.bd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utfpr.bd.domain.Contato;
import com.utfpr.bd.domain.projecao.NomeCidade;
import com.utfpr.bd.domain.projecao.SemEndereco;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	Contato findByNomeAndIdade(String nome, Integer idade);

	List<Contato> findByEnderecoCidade(String cidade);

	Contato findFirstBy();

	Contato findTopByOrderByIdadeAsc();

	List<Contato> findFirst3ByOrderByIdadeAsc();

	@Query("select c from Contato c  where idade >= 18 order by nome asc")
	List<Contato> findByContatoMaiolrdade();

	// query sobscreve o metodo
	@Query("select c from Contato c where c.dtCadastro > ?1")
	List<Contato> findByDtCadastroAfter(Date dataCadastro);

	// native query
	@Query(value = "select * from contatos where data_cadastro = ?1", nativeQuery = true)
	List<Contato> findByOataCadastro(Date dataCadastro);

	@Query(name = "Contato.byIdade")
	List<Contato> findByIdade(Integer idade);

	@Query(name = "Contato.byNome")
	Contato findByNome(String nome);
	
	SemEndereco findContatoByNome(String nome);
	
	NomeCidade findContatoCidadeByNome(String nome);
}
