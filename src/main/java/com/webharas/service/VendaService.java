package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Venda;
import com.webharas.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}
	
	public Venda findById(long id) {
		return vendaRepository.findById(id);
	}
	
	public Venda save(Venda venda) {
		return vendaRepository.save(venda);
	}
	
	public Venda update(long id, Venda venda) {
		venda.setId(id);
		return vendaRepository.save(venda);
	}
	
	public void delete(long id) {
		vendaRepository.deleteById(id);
		return;
	}
}
