package com.example.accessingdatamysql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.accessingdatamysql.entities.Curso;
import com.example.accessingdatamysql.repositories.CursoRepository;
import com.example.accessingdatamysql.services.CursoService;

@Controller
@RequestMapping(path = "/demo")
public class CursoController {

	@Autowired
	private CursoService cursoservice;
	@Autowired
	private CursoRepository cursoRepository;

	@RequestMapping("/cursos")
	public String setCursoForm(Model model) {

		Iterable<Curso> listas = cursoRepository.findAll();
		model.addAttribute("miListaCurso", listas);
		model.addAttribute("miLista", new Curso());
		return "formularioCurso";
	}

	@PostMapping(path = "/addCurso")
	public RedirectView addNewCurso(String nombreCurso, Integer horas) {

		cursoservice.addNewCurso(nombreCurso, horas);

		return new RedirectView("/demo/listado");
	}
}
