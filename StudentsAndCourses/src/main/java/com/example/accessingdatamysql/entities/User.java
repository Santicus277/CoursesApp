package com.example.accessingdatamysql.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "usuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	public String nombre;
	public String apellido;
	public String email;
	public String password;
	
	
	
	
}
