package br.com.redemob.rocket.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.redemob.rocket.api.domain.model.Inscricao;
import br.com.redemob.rocket.api.domain.model.Usuario;
import br.com.redemob.rocket.api.repository.InscricaoRepository;
import br.com.redemob.rocket.api.repository.UsuarioRepository;


@Controller
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	InscricaoRepository inscricaoRepository;

	@GetMapping("/rocket/login")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "login";
		
	}
	
	@PostMapping("/rocket/logar")
	public String logar(Model model, String cpf, String senha, String lembrarse) {
		String rota =null;
		Optional<?> optusua = usuarioRepository.Logar(cpf, senha);
		rota = "login";
		List<String> statusList = Arrays.asList("EM ANALISE","APROVADO", "REPROVADO");
		


		// Caso retorne vazio, ou usuário e senha está errado ou cadastro não existe
  		if (!optusua.isEmpty()) {
			Usuario usuarioLogado = (Usuario) optusua.get();
			
			model.addAttribute("pessoa", usuarioLogado.getPessoa());
			model.addAttribute("logado", true);			
			Boolean checkCondicao=true; 
			
			// status de tudo ok, se mudar é que ocorreu menos de 24 horas em uma inscrição que está sendo analisada
			LocalDateTime dataAtual = LocalDateTime.now();
			LocalDateTime dataInscricao;
			long diferencaHoras=0;
			long diferencaMin=0;
			
			// se for administrador/avaliador, lista todas as inscrições em ordem decrescente 
			if (usuarioLogado.getAdmin()) {
				String status="";
				model.addAttribute("inscricoes", inscricaoRepository.findAll(Sort.by(Sort.Direction.DESC,"dataInscricao")));
				model.addAttribute("admin", true);
				model.addAttribute("statusList",statusList);
				model.addAttribute("statusNovo", status);
			}else { // ser for usuário comum

				//verifica se já passou 24 da ultima inscrição em analise
				for (Inscricao inscricao : usuarioLogado.getPessoa().getInscricoes()) {
					
					if (inscricao.getStatus().equals("EM ANALISE")) {
						dataInscricao = inscricao.getDataInscricao();	
						diferencaHoras = ChronoUnit.HOURS.between(dataInscricao, dataAtual);
						diferencaMin = ChronoUnit.MINUTES.between(dataInscricao, dataAtual);

						if (diferencaHoras<24) {
							checkCondicao= false;
						}
					}
					
				}
				

				model.addAttribute("admin", false);
				model.addAttribute("inscricoes", usuarioLogado.getPessoa().getInscricoes());
			}
			
			if (!checkCondicao) {
				model.addAttribute("erro", "Você fez o cadastro da inscrição, porem ainda está em prazo para analise, se passaram "+diferencaHoras+":"+diferencaMin+", volte após 24 horas");
				rota="login";
			}else {
				rota ="inscricao-list"; // se estiver tudo ok, segue o caminho.
			}
		} else {
			model.addAttribute("erro", "Usuário ou senha inválidos!");
		}

		return rota;
	}
	

}
