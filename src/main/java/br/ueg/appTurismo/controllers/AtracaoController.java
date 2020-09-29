package br.ueg.appTurismo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.appTurismo.models.Atracao;
import br.ueg.appTurismo.services.AtracaoService;

@RestController
public class AtracaoController {
	
	@Autowired
	private AtracaoService atracaoService;
	

	public AtracaoController(AtracaoService atracaoService) {
		this.atracaoService = atracaoService;
	}
	
	@GetMapping("/atracao")
	public List<Atracao> listAtracao(){
		return atracaoService.listAtracao();
	}
	
	@PostMapping("/atracao")
	public Atracao saveAtracao(@RequestBody Atracao atracao) {
		return atracaoService.saveAtracao(atracao);
	}
	
	@GetMapping("/atracao/{id}")
	public Optional<Atracao> findById(@PathVariable long id) { 
		return atracaoService.findAtracaoById(id);
	}
	
	@DeleteMapping("/atracao/{id}")
	public void deleteById(@PathVariable long id) {
		atracaoService.deleteAtracao(id);
	}
}
