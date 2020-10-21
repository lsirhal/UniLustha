package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository < Avaliacao, Integer> {
	

}
