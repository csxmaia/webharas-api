package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem,Long> {
	Imagem findById(long id);

}
