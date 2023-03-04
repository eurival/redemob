package br.com.redemob.rocket.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.redemob.rocket.domain.model.Pessoa;
import br.com.redemob.rocket.repository.PessoaRepository;
import br.com.redemob.rocket.service.CadastroPessoaService;

@RestController
@RequestMapping("/cidade")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CadastroPessoaService cadastroPessoaService;
	
	@GetMapping()
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAllByNomePessoaAsc();
	}

}
