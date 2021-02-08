package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Haras;
import com.webharas.repository.HarasRepository;

@Service
public class HarasService {
	
	@Autowired
	private HarasRepository harasRepository;
	
	public List<Haras> findAll() {
		return harasRepository.findAll();
	}
	
	public Haras findById(long id) {
		return harasRepository.findById(id);
	}
	
	public Haras save(Haras haras) {
		return harasRepository.save(haras);
	}
	
	public Haras update(long id, Haras haras) {
		haras.setId(id);
		return harasRepository.save(haras);
	}
	
	public void delete(long id) {
		harasRepository.deleteById(id);
		return;
	}

}
