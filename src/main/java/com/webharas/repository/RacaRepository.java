package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long> {
	
	Raca findById(long id);

}
