package br.com.redemob.rocket.api.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.redemob.rocket.api.domain.exception.EntidadeEmUsoException;
import br.com.redemob.rocket.api.domain.exception.EntidadeNaoEncontradaException;
import br.com.redemob.rocket.api.domain.model.Pessoa;
import br.com.redemob.rocket.api.repository.PessoaRepository;
import br.com.redemob.rocket.api.service.CadastroPessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	private final Logger log = LoggerFactory.getLogger(PessoaController.class);
	private static final String ENTITY_NAME = "pessoa";
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CadastroPessoaService cadastroPessoaService;
	
	@GetMapping()
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@Valid @RequestBody Pessoa pessoa) 	{
		log.debug("Chamada REST para salvar a Pessoa : {}", pessoa);
		
		try {
			pessoa = cadastroPessoaService.salvar(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
	
	}
	

}
