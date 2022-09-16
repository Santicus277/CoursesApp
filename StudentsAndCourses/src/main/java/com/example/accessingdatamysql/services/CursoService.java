package com.example.accessingdatamysql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import com.example.accessingdatamysql.entities.Curso;
import com.example.accessingdatamysql.repositories.CursoRepository;

@Service

public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public RedirectView addNewCurso(String nombreCurso, Integer horas) {

		Curso c = new Curso();
		c.setNombreCurso(nombreCurso);
		c.setHoras(horas);
		cursoRepository.save(c);

		return new RedirectView("/demo/listado");
	}

}
