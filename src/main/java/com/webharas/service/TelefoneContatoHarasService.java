package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.TelefoneContatoHaras;
import com.webharas.repository.TelefoneContatoHarasRepository;

@Service
public class TelefoneContatoHarasService {
	
	@Autowired
	private TelefoneContatoHarasRepository telefoneContatoHarasRepository;
	
	public List<TelefoneContatoHaras> findAll() {
		return telefoneContatoHarasRepository.findAll();
	}
	
	public TelefoneContatoHaras findById(long id) {
		return telefoneContatoHarasRepository.findById(id);
	}
	
	public TelefoneContatoHaras save(TelefoneContatoHaras usuario) {
		return telefoneContatoHarasRepository.save(usuario);
	}
	
	public TelefoneContatoHaras update(long id, TelefoneContatoHaras usuario) {
		usuario.setId(id);
		return telefoneContatoHarasRepository.save(usuario);
	}
	
	public void delete(long id) {
		telefoneContatoHarasRepository.deleteById(id);
		return;
	}
}
