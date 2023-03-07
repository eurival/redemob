package br.com.redemob.rocket.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.redemob.rocket.api.domain.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Pessoa findByCpf(String cpf);
	
}
