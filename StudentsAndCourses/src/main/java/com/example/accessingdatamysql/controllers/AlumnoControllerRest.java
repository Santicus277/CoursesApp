package com.example.accessingdatamysql.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.accessingdatamysql.entities.Curso;
import com.example.accessingdatamysql.entities.Estudiante;
import com.example.accessingdatamysql.repositories.CursoRepository;
import com.example.accessingdatamysql.repositories.PersonaRepository;
import com.example.accessingdatamysql.repositories.UserRepository;
import com.example.accessingdatamysql.services.AlumnoService;

@RestController
@RequestMapping(path = "/demo")
public class AlumnoControllerRest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private PersonaRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AlumnoService alumnoservice;

	@GetMapping("/cursoRest")
	  List<Curso> todos() {
	    return cursoRepository.findAll();
	  }
	
	
	 @GetMapping("/estudiantesRest")
	  List<Estudiante> all() {
	    return userRepository.findAll();
	  }
	 

	  @DeleteMapping("/delete/{id}")
	  void deleteEmployee(@PathVariable Integer id) {
		  userRepository.deleteById(id);
	  }
	 
	 
}