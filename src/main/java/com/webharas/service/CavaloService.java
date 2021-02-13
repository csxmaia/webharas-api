package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Cavalo;
import com.webharas.model.exceptions.NotFoundException;
import com.webharas.repository.CavaloRepository;

@Service
public class CavaloService {
	
	@Autowired
	private CavaloRepository cavaloRepository;
	
	public List<Cavalo> findAllAVenda() {
		return cavaloRepository.findAllAVenda();
	}
	
	public List<Cavalo> findAll() {
		return cavaloRepository.findAll();
	}
	
	public Cavalo findById(long id) throws NotFoundException {
		Cavalo cavalo = cavaloRepository.findById(id);
		if(cavalo == null) {
			throw new NotFoundException();
		}
		return cavalo;
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
