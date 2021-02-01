package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	Estado findById(long id);
	
}
