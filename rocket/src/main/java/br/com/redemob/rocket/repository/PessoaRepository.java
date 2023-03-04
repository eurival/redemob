package br.com.redemob.rocket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.com.redemob.rocket.domain.model.Pessoa;

/**
 * Spring Data JPA repository for the Pessoa entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	public List<Pessoa> findAllByNomePessoaAsc();  // retorna todas as pessoas por order crescento// poderia implemnetar paginação tb. 
}
