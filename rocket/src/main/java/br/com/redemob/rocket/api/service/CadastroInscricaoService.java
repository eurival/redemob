package br.com.redemob.rocket.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.redemob.rocket.api.domain.model.Inscricao;
import br.com.redemob.rocket.api.repository.InscricaoRepository;
import jakarta.transaction.Transactional;

@Service
public class CadastroInscricaoService {
	
	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	@Transactional
	public Inscricao salvar(Inscricao inscricao) {
		return inscricaoRepository.save(inscricao);
	}
	
	public Inscricao buscarPorId(Long id) {
		return inscricaoRepository.findById(id).get();
	}
	
	
		
}
