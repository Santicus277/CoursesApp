package com.example.accessingdatamysql.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name = "alumno")
@Data
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String email;

	@OneToOne
	private Curso miCurso;

	public Estudiante() {

	}

}
