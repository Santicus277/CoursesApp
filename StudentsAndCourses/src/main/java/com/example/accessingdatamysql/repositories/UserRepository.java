package com.example.accessingdatamysql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.accessingdatamysql.entities.AlumnoEnCurso;
import com.example.accessingdatamysql.entities.Estudiante;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<Estudiante, Integer> {
	

	@Query("SELECT new AlumnoEnCurso (a.id,a.name,a.email) FROM alumno a ")
	List<AlumnoEnCurso> alumnoEnCurso();


}
