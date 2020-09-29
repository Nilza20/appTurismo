package br.ueg.appTurismo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.appTurismo.models.Estabelecimento;
import br.ueg.appTurismo.repositories.EstabelecimentoRepository;


@Service
public class EstabelecimentoServices {
	
	@Autowired
	private final EstabelecimentoRepository estabelecimentoRepository;
	
	public EstabelecimentoServices(EstabelecimentoRepository estabelecimentoRepository) {
		this.estabelecimentoRepository = estabelecimentoRepository;
	}
	
	public Estabelecimento saveEstabelecimento(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}
	
	public List<Estabelecimento> listEstabelecimento(){
		return estabelecimentoRepository.findAll();
	}
	
	public void deleteEstabelecimento(Long id) {
		estabelecimentoRepository.deleteById(id);
	}
	
	public Optional<Estabelecimento> findEstabelecimentoById(Long id){
		return estabelecimentoRepository.findById(id);
	}
}

