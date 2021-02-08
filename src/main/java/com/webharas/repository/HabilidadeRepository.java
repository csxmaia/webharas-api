package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
	
	Habilidade findById(long id);

}
