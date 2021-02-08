package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Genero;
import com.webharas.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}
	
	public Genero findById(long id) {
		return generoRepository.findById(id);
	}
	
	public Genero save(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero update(long id, Genero genero) {
		genero.setId(id);
		return generoRepository.save(genero);
	}
	
	public void delete(long id) {
		generoRepository.deleteById(id);
		return;
	}

}
