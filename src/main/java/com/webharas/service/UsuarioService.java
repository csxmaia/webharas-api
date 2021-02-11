package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.DTO.UsuarioLoginRequestDTO;
import com.webharas.model.Usuario;
import com.webharas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public String login(UsuarioLoginRequestDTO usuario) {
		Usuario usuarioEmail = usuarioRepository.findByEmail(usuario.getEmail());
		if(usuarioEmail == null) {
			throw emailNaoEncontrado();
		}
		
		boolean isEqual = usuario.getSenha().equals(usuarioEmail.getSenha());
		if(!isEqual) {
			throw senhaInvalida();
		}
		
		return usuarioEmail.getNome();
	}
	
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
	
	private RuntimeException senhaInvalida() {
        return new RuntimeException("Usuario ou senha invalidos");
    }
	
	private RuntimeException emailNaoEncontrado() {
        return new RuntimeException("Email não encontrado");
    }
}
