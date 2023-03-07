package br.com.redemob.rocket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.redemob.rocket.api.domain.model.Usuario;
import br.com.redemob.rocket.api.repository.UsuarioRepository;


@Controller
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/rocket/login")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "login";
		
	}
	
	@PostMapping("/rocket/logar")
	public String logar(Model model, String cpf, String senha, String lembrarse) {
		String rota =null;
		Optional<?> optusua = usuarioRepository.Logar(cpf, senha);
		
		// Caso retorne vazio, ou usuário e senha está errado ou cadastro não existe
		if (!optusua.isEmpty()) {
			Usuario usuarioLogado = (Usuario) optusua.get();
			
			
			if (usuarioLogado.getAdmin()) {
				rota = "/rocket/administrador";
			}else {
				rota = "/rocket/acompanharsolicitacao/{"+usuarioLogado.getPessoa().getId()+ "}";
			}
		} else {
			rota = "login";
			model.addAttribute("erro", "Usuário ou senha inválidos!");
		}

		return rota;
	}

}
