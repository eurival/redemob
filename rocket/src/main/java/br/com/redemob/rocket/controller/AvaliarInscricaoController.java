package br.com.redemob.rocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.redemob.rocket.api.repository.UsuarioRepository;

@Controller
public class AvaliarInscricaoController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/rocket/acompanharsolicitacao/{id}")
	public String index(@RequestParam(name="id", required=true) Long id, Model model) {
		model.addAttribute("id", id);
		
		return "login";
		
	}

}
