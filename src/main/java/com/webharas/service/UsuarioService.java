package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Usuario;
import com.webharas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(long id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(long id, Usuario usuario) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}
	
	public void delete(long id) {
		usuarioRepository.deleteById(id);
		return;
	}
}
