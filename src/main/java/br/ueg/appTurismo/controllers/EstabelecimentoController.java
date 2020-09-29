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

import br.ueg.appTurismo.models.Estabelecimento;
import br.ueg.appTurismo.services.EstabelecimentoServices;


@RestController
public class EstabelecimentoController {
	@Autowired
	private EstabelecimentoServices estabelecimentoServices;
	

	public EstabelecimentoController(EstabelecimentoServices estabelecimentoServices) {
		this.estabelecimentoServices = estabelecimentoServices;
	}
	
	@GetMapping("/estabelecimento")
	public List<Estabelecimento> listEstabelecimento(){
		return estabelecimentoServices.listEstabelecimento();
	}
	
	@PostMapping("/estabelecimento")
	public Estabelecimento saveEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
		return estabelecimentoServices.saveEstabelecimento(estabelecimento);
	}
	
	@GetMapping("/estabelecimento/{id}")
	public Optional<Estabelecimento> findById(@PathVariable long id) { 
		return estabelecimentoServices.findEstabelecimentoById(id);
	}
	
	@DeleteMapping("/estabelecimento/{id}")
	public void deleteById(@PathVariable long id) {
		estabelecimentoServices.deleteEstabelecimento(id);
	}
}
