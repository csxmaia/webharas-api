package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Estado;
import com.webharas.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}
	
	public Estado findById(long id) {
		return estadoRepository.findById(id);
	}
	
	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public Estado update(long id, Estado estado) {
		estado.setId(id);
		return estadoRepository.save(estado);
	}
	
	public void delete(long id) {
		estadoRepository.deleteById(id);
		return;
	}
}
