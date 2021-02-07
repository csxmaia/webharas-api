package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.webharas.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	Cidade findById(long id);
	
}
