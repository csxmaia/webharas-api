package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Pelagem;

public interface PelagemRepository extends JpaRepository<Pelagem, Long> {
	
	Pelagem findById(long id);

}
