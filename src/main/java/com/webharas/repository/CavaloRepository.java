package com.webharas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webharas.model.Cavalo;

public interface CavaloRepository extends JpaRepository<Cavalo, Long> {
	
	Cavalo findById(long id);
	
	@Query("SELECT c FROM Cavalo c WHERE c.vendido = 0")
	List<Cavalo> findAllAVenda();

}
