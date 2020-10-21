package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Turma;
import br.com.senac.service.TurmaService;

@Component
public class InitTurma implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	TurmaService turmaService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<Turma> listaTurmas = turmaService.buscarTodosTurmas();
		
			
		}		
	}