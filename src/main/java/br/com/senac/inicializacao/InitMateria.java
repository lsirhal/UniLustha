package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Materia;
import br.com.senac.service.MateriaService;

@Component
public class InitMateria implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	MateriaService materiaService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {



		List<Materia> listaMaterias = materiaService.buscarTodosMaterias();
		
		for (Materia materia : listaMaterias) {
			System.out.println(materia.getNome());		
		}		
	}
}