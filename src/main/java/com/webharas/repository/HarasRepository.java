package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Haras;

public interface HarasRepository extends JpaRepository<Haras, Long>{
	
	Haras findById(long id);

}
