package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Curso;
import br.com.senac.service.CursoService;

@Component
public class InitCurso implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	CursoService cursoService;
	
	@Override
	public void onApplicationEvent (ContextRefreshedEvent event) {	
		
		List<Curso> listaCursos= cursoService.buscarTodosCursos();		
		
		for (Curso curso : listaCursos) {
			System.out.println(curso.getNome());
		}
	}
}
