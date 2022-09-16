package com.example.accessingdatamysql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.accessingdatamysql.entities.Curso;
import com.example.accessingdatamysql.entities.Estudiante;
import com.example.accessingdatamysql.repositories.CursoRepository;
import com.example.accessingdatamysql.repositories.UserRepository;

@Service
public class AlumnoService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CursoRepository cursoRepository;

	public RedirectView addNewUser(String name, String email, Integer id) {

		Estudiante n = new Estudiante();
		n.setName(name);
		n.setEmail(email);
		n.setMiCurso(cursoRepository.findById(id).get());
		userRepository.save(n);
		return new RedirectView("/demo/listado");
	}

	public String deleteUser(@RequestParam Integer id) {

		userRepository.deleteById(id);

		return ("redirect:/demo/listado");
	}

}
