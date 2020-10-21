package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Curso;
import br.com.senac.service.CursoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/listar")
	public ModelAndView listaTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/listarCursos");
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		return mv;	
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCurso() {
		ModelAndView mv = new ModelAndView("curso/cadastrarCurso");
		mv.addObject("curso", new Curso());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Curso Curso) {
		cursoService.salvar(Curso);
		return listaTodosCursos();
	}


	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCurso(@PathVariable("id") Integer idCurso) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("curso/alterarCurso");
		mv.addObject("curso", cursoService.buscaPorID(idCurso));
		return mv;
	}


	@PostMapping("/alterar")
	public ModelAndView alterar(Curso cursoAlterado) throws ObjectNotFoundException{
		cursoService.salvarAlteracao(cursoAlterado);
		return listaTodosCursos();
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluirCurso(@PathVariable("id") Integer id) {
		cursoService.excluir(id);
		return listaTodosCursos();
	}

}