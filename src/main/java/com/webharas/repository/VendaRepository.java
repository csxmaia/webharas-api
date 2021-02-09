package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	Venda findById(long id);

}
