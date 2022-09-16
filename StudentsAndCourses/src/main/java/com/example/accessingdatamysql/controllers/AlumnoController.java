package com.example.accessingdatamysql.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.accessingdatamysql.dto.AlumnoDto;
import com.example.accessingdatamysql.entities.Curso;
import com.example.accessingdatamysql.entities.Estudiante;
import com.example.accessingdatamysql.entities.User;
import com.example.accessingdatamysql.repositories.CursoRepository;
import com.example.accessingdatamysql.repositories.PersonaRepository;
import com.example.accessingdatamysql.repositories.UserRepository;
import com.example.accessingdatamysql.services.AlumnoService;

@Controller
@RequestMapping(path = "/demo")
public class AlumnoController {

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

	@PostMapping(path = "/add")
	public RedirectView addNewUser(String name, String email, Integer id) {

		alumnoservice.addNewUser(name, email, id);
		return new RedirectView("/demo/listado");
	}

	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping(path = "/del")
	public String deleteUser(@RequestParam Integer id) {

		alumnoservice.deleteUser(id);

		return ("redirect:/demo/listado");
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Estudiante> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@RequestMapping("/alumnos")
	public String setUserForm(Model model) {
		Iterable<Curso> lista = cursoRepository.findAll();
		model.addAttribute("miListaCurso", lista);
		model.addAttribute("miLista", new Estudiante());
		return "formularioAlta";
	}

	@RequestMapping("/listado")
	public String muestraListado(Model model) {
		Iterable<Curso> listas = cursoRepository.findAll();
		model.addAttribute("miListaCurso", listas);
		Iterable<Estudiante> lista = userRepository.findAll();
		model.addAttribute("miLista", lista);
		return "listado";
	}

	@GetMapping("/edit")
	public String showUpdateForm(@RequestParam Integer id, Model model) {

		Iterable<Curso> listas = cursoRepository.findAll();
		model.addAttribute("miListaCurso", listas);
		Estudiante estudiante = userRepository.findById(id).get();
		model.addAttribute("miLista", estudiante);

		return "formularioEditar";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, Model model, Estudiante estudiante) {
		estudiante.setId(id);
		model.addAttribute("miLista", estudiante);
		userRepository.save(estudiante);

		return "redirect:/demo/listado";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);

		return "register_success";
	}

//	@PutMapping("/updateNew")
//	public ResponseEntity<AlumnoDto> showUpdateForm(@PathVariable Integer id, @RequestBody AlumnoDto alumnodto) {
//		
//		Estudiante estudianteRequest= modelMapper.map(alumnodto, Estudiante.class);
//		Estudiante estudiante=alumnoservice.showUpdateForm(id, estudianteRequest);
//
//		AlumnoDto estudianteResponse= modelMapper.map(estudiante, AlumnoDto.class);
//		return ResponseEntity.ok().body(estudianteResponse);
//	}
//	
}
