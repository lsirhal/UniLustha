package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;

@Component
public class InitAluno implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoService alunoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
//Removido do código, pois toda vez que rodar o projeto, ira criar esses alunos novamente. Como não está usando mais o banco em 
//memoria, foi necessário remover.
//
//		Aluno aluno1 = new Aluno();
//		aluno1.setNome("Lucas");
//		alunoService.salvar(aluno1);
//		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		for (Aluno aluno : listaAlunos) {
			System.out.println(aluno.getNome());		
		}		
	}
}