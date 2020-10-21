package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Materia;

@Repository
public interface MateriaRepository extends JpaRepository < Materia, Integer> {
	

}
