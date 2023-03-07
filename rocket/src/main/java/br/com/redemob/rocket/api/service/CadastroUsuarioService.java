package br.com.redemob.rocket.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.redemob.rocket.api.domain.model.Usuario;
import br.com.redemob.rocket.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	


}
