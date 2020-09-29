package br.ueg.appTurismo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.appTurismo.models.Atracao;
import br.ueg.appTurismo.repositories.AtracaoRepository;

@Service
public class AtracaoService {

	@Autowired
	private final AtracaoRepository atracaoRepository;
	
	public AtracaoService(AtracaoRepository atracaoRepository) {
		this.atracaoRepository = atracaoRepository;
	}
	
	public Atracao saveAtracao(Atracao atracao) {
		return atracaoRepository.save(atracao);
	}
	
	public List<Atracao> listAtracao(){
		return atracaoRepository.findAll();
	}
	
	public void deleteAtracao(Long id) {
		atracaoRepository.deleteById(id);
	}
	
	public Optional<Atracao> findAtracaoById(Long id){
		return atracaoRepository.findById(id);
	}
}
