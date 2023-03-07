package br.com.redemob.rocket.api.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.com.redemob.rocket.api.domain.model.Cidade;

/**
 * Repositorio para a entidade Cidade
 */
@SuppressWarnings("unused")
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {}
