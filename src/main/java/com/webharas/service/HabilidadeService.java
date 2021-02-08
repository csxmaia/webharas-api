package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Habilidade;
import com.webharas.repository.HabilidadeRepository;

@Service
public class HabilidadeService {
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	public List<Habilidade> findAll(){
		return habilidadeRepository.findAll();
	}
	
	public Habilidade findById(long id) {
		return habilidadeRepository.findById(id);
	}
	
	public Habilidade save(Habilidade habilidade) {
		return habilidadeRepository.save(habilidade);
	}
	
	public Habilidade update(long id, Habilidade habilidade) {
		habilidade.setId(id);
		return habilidadeRepository.save(habilidade);
	}
	
	public void delete(long id) {
		habilidadeRepository.deleteById(id);
		return;
	}

}
