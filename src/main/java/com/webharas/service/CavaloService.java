package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Cavalo;
import com.webharas.repository.CavaloRepository;

@Service
public class CavaloService {
	
	@Autowired
	private CavaloRepository cavaloRepository;
	
	public List<Cavalo> findAll() {
		return cavaloRepository.findAll();
	}
	
	public Cavalo findById(long id) {
		return cavaloRepository.findById(id);
	}
	
	public Cavalo save(Cavalo cavalo) {
		return cavaloRepository.save(cavalo);
	}
	
	public Cavalo update(long id, Cavalo cavalo) {
		cavalo.setId(id);
		return cavaloRepository.save(cavalo);
	}
	
	public void delete(long id) {
		cavaloRepository.deleteById(id);
		return;
	}

}
