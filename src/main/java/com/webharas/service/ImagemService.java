package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Imagem;
import com.webharas.repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;
	
	public List<Imagem> findAll(){
		return imagemRepository.findAll();
	}
	
	public Imagem findById(long id) {
		return imagemRepository.findById(id);
	}

	public Imagem save(Imagem imagem) {
		return imagemRepository.save(imagem);
	}
	
	public Imagem update(long id,Imagem imagem) {
		imagem.setId(id);
		return imagemRepository.save(imagem);
	}
	
	public void delete(long id) {
		imagemRepository.deleteById(id);
		return;
	}
	
}
