package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Modulo;
import br.com.senac.service.ModuloService;

@Component
public class InitModulo implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	ModuloService moduloService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<Modulo> listaModulos = moduloService.buscarTodosModulos();
		
			
		}		
	}
