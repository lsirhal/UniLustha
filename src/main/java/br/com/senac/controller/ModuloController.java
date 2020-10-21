package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Modulo;
import br.com.senac.service.CursoService;
import br.com.senac.service.MateriaService;
import br.com.senac.service.ModuloService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("modulo")
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private MateriaService materiaService; 
	
	@GetMapping("/listar")
	public ModelAndView listaTodosModulos() {
		ModelAndView mv = new ModelAndView("modulo/listarModulos");
		mv.addObject("modulos", moduloService.buscarTodosModulos());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarModulo() {
		ModelAndView mv = new ModelAndView("modulo/cadastrarModulo");
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		mv.addObject("materias", materiaService.buscarTodosMaterias());
		mv.addObject("modulo", new Modulo());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarModulo(Modulo modulo) {
		moduloService.salvar(modulo);
		return listaTodosModulos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarModulo(@PathVariable("id") Integer idModulo) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("modulo/alterarModulo");
		mv.addObject("modulo", moduloService.buscaPorID(idModulo));
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		mv.addObject("materias", materiaService.buscarTodosMaterias());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Modulo moduloAlterado) throws ObjectNotFoundException{
		moduloService.salvarAlteracao(moduloAlterado);
		return listaTodosModulos();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirModulo(@PathVariable("id") Integer id) {
		moduloService.excluir(id);
		return listaTodosModulos();
	}
	
}
