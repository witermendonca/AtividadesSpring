package com.generation.primeiroProjeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividade")
public class HabilidadesMentalidadesController {

	@GetMapping
	public String persistencia() {
		
		return "Nas Atividade de Spring, a principal mentalidade que usei foi a de persistência. Persistência pois revisei os vídeos mais de uma vez para absorver realmente o conteúdo.";
				
	}
	
	@GetMapping("/crescimento")
	public String crescimento() {
		
		return"Outra mentalidade foi a Mentalidade de Crescimento, pois estou adquirindo novos conhecimentos.";
				
	}
	
	@GetMapping("/atencao")
	public String atencao() {
		
		return"A principal Habilidade que usei foi a de Atenção aos Detalhes, pois estamos aprendendo novos conteúdo.";
				
				
	}
	
	@GetMapping("/comunicacao")
	public String comunicacao() {
		
		return"Outra Habilidade que usei foi a de Comunicação, para tirar minhas dúvidas e absorver de maneira mais acertiva o conteúdo.";
				
				
	}
}
