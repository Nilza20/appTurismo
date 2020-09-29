package br.ueg.appTurismo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ueg.appTurismo.models.Atracao;

@Repository
public interface AtracaoRepository extends JpaRepository<Atracao, Long>{

}
