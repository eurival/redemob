package br.com.redemob.rocket.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.com.redemob.rocket.domain.model.Cidade;

/**
 * Repositorio para a entidade Cidade
 */
@SuppressWarnings("unused")
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {}
