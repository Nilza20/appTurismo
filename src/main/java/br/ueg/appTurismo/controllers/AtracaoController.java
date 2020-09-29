package br.ueg.appTurismo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.ApiOperation;

import br.ueg.appTurismo.models.Atracao;
import br.ueg.appTurismo.services.AtracaoService;

@RestController
@RequestMapping ("/atracoes")
public class AtracaoController {
	
	@Autowired
	private AtracaoService atracaoService;
	

	public AtracaoController(AtracaoService atracaoService) {
		this.atracaoService = atracaoService;
	}
	
	
	@GetMapping
	@ResponseBody
	@ApiOperation(value = "Método para listar todas as atrações disponivel na cidade de Shego.")
	public List<Atracao> listAtracao(){
		return atracaoService.listAtracao();
	}
	
	@PostMapping
	@ResponseBody
	@ApiOperation(value ="salva um atrações, não possui campo obrigatório.")
	public Atracao saveAtracao(@RequestBody Atracao atracao) {
		return atracaoService.saveAtracao(atracao);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Atracao findById(@PathVariable(value = "id") Long id) {
		
		return atracaoService.findById(id);
	}

	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteById(@PathVariable long id) {
		atracaoService.deleteAtracao(id);
	}
	
}
