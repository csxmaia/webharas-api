package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Raca;
import com.webharas.repository.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository racaRepository;
	
	public List<Raca> findAll() {
		return racaRepository.findAll();
	}
	
	public Raca findById(long id) {
		return racaRepository.findById(id);
	}
	
	public Raca save(Raca raca) {
		return racaRepository.save(raca);
	}
	
	public Raca update(long id, Raca raca) {
		raca.setId(id);
		return racaRepository.save(raca);
	}
	
	public void delete(long id) {
		racaRepository.deleteById(id);
		return;
	}
	

}
