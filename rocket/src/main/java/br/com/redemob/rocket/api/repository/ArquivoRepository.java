package br.com.redemob.rocket.api.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.com.redemob.rocket.api.domain.model.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
	
}
