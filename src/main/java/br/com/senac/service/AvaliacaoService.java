package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Avaliacao;
import br.com.senac.repository.AvaliacaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AvaliacaoService {
	
	@Autowired
	AvaliacaoRepository repoAvaliacao;
		
	public List<Avaliacao> buscarTodosAvaliacoes(){
		return repoAvaliacao.findAll();
	}
		
	public Avaliacao salvar(Avaliacao avaliacao) {
		return repoAvaliacao.save(avaliacao);
	}
	
	public Avaliacao buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Avaliacao> avaliacao = repoAvaliacao.findById(id);
		return avaliacao.orElseThrow(() -> new ObjectNotFoundException("Avaliacao não encontrado. ID: " + id));
	}
	
	public Avaliacao salvarAlteracao(Avaliacao avaliacaoAlterado) throws ObjectNotFoundException{
		Avaliacao avaliacao = buscaPorID(avaliacaoAlterado.getId());
		avaliacao.setId(avaliacaoAlterado.getId());
		avaliacao.setNome(avaliacaoAlterado.getNome());
		avaliacao.setDescricao(avaliacaoAlterado.getDescricao());
		avaliacao.setMateria(avaliacaoAlterado.getMateria());
		return salvar(avaliacao);
	}
	
	public void excluir (Integer id) {
		repoAvaliacao.deleteById(id);
	}

}
