package br.ueg.appTurismo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.appTurismo.models.Estabelecimento;
import br.ueg.appTurismo.services.EstabelecimentoServices;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping ("/estabelecimentos")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoServices estabelecimentoServices;
	

	public EstabelecimentoController(EstabelecimentoServices estabelecimentoServices) {
		this.estabelecimentoServices = estabelecimentoServices;
	}
	
	@GetMapping
	@ResponseBody
	@ApiOperation(value = "Método para listar todas os estabelecimentos na cidade de Shego.")
	public List<Estabelecimento> listEstabelecimento(){
		return estabelecimentoServices.listEstabelecimento();
	}
	
	@PostMapping
	@ResponseBody
	public Estabelecimento saveEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
		return estabelecimentoServices.saveEstabelecimento(estabelecimento);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Estabelecimento findById(@PathVariable long id) { 
		return estabelecimentoServices.findEstabelecimentoById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteById(@PathVariable long id) {
		estabelecimentoServices.deleteEstabelecimento(id);
	}
}
