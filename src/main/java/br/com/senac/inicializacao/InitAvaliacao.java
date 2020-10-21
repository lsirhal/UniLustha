package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import br.com.senac.domain.Avaliacao;
import br.com.senac.service.AvaliacaoService;


@Component
public class InitAvaliacao implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AvaliacaoService avaliacaoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {


		
		List<Avaliacao> listaAvaliacoes = avaliacaoService.buscarTodosAvaliacoes();
		
		for (Avaliacao avaliacao : listaAvaliacoes) {
			System.out.println(avaliacao.getNome());		
		}		
	}
}
