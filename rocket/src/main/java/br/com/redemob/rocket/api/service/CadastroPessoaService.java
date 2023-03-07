package br.com.redemob.rocket.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.redemob.rocket.api.domain.model.Pessoa;
import br.com.redemob.rocket.api.repository.PessoaRepository;
import jakarta.transaction.Transactional;

@Service
public class CadastroPessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	
		
}
