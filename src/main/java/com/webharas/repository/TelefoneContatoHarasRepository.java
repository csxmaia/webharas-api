package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.TelefoneContatoHaras;

public interface TelefoneContatoHarasRepository extends JpaRepository<TelefoneContatoHaras, Long>{
	
	TelefoneContatoHaras findById(long id);
	
}
