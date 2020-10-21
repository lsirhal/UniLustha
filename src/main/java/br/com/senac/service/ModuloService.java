package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Modulo;
import br.com.senac.repository.ModuloRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ModuloService {

	@Autowired
	ModuloRepository repoModulo;

	public List<Modulo> buscarTodosModulos(){
		return repoModulo.findAll();
	}
	public Modulo salvar(Modulo modulo) {
		return repoModulo.save(modulo);
	}
	public Modulo buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Modulo> modulo = repoModulo.findById(id);
		return modulo.orElseThrow(() -> new ObjectNotFoundException("Modulo não encontrado . id: " + id));
	}

	public Modulo salvarAlteracao(Modulo moduloAlterado) throws ObjectNotFoundException{	
		Modulo modulo = buscaPorID(moduloAlterado.getId());
		modulo.setId(moduloAlterado.getId());
		modulo.setDescricao(moduloAlterado.getDescricao());
		modulo.setCurso(moduloAlterado.getCurso());
		modulo.setMaterias(moduloAlterado.getMaterias());	
		return salvar(modulo);
	}


	public void excluir(Integer id) {
		repoModulo.deleteById(id);
	}
}
