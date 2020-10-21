package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
