package com.example.accessingdatamysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.accessingdatamysql.entities.Curso;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
