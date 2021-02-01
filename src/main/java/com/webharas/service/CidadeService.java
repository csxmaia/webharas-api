package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Cidade;
import com.webharas.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}
	
	public Cidade findById(long id) {
		return cidadeRepository.findById(id);
	}
	
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public Cidade update(long id, Cidade cidade) {
		cidade.setId(id);
		return cidadeRepository.save(cidade);
	}
	
	public void delete(long id) {
		cidadeRepository.deleteById(id);
		return;
	}
}
