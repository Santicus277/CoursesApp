package com.example.accessingdatamysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.accessingdatamysql.entities.Curso;
import com.example.accessingdatamysql.entities.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PersonaRepository extends JpaRepository<User, Long> {
	  @Query("SELECT u FROM usuario u WHERE u.email = ?1")
	    public User findByEmail(String email);
}
