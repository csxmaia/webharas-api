package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Pelagem;
import com.webharas.repository.PelagemRepository;

@Service
public class PelagemService {
	
	@Autowired
	private PelagemRepository pelagemRepository;
	
	public List<Pelagem> findAll() {
		return pelagemRepository.findAll();
	}
	
	public Pelagem findById(long id) {
		return pelagemRepository.findById(id);
	}
	
	public Pelagem save(Pelagem pelagem) {
		return pelagemRepository.save(pelagem);
	}
	
	public Pelagem update(long id, Pelagem pelagem) {
		pelagem.setId(id);
		return pelagemRepository.save(pelagem);
	}
	
	public void delete(long id) {
		pelagemRepository.deleteById(id);
		return;
	}

}
