package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Cavalo;

public interface CavaloRepository extends JpaRepository<Cavalo, Long> {
	
	Cavalo findById(long id);

}
