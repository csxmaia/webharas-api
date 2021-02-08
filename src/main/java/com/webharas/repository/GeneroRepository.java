package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long>{
	
	Genero findById(long id);

}
