package com.example.accessingdatamysql.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.example.accessingdatamysql.entities.Curso;

import lombok.Data;

@Data
public class EstudianteDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String email;

	private Curso miCurso;

	
}
