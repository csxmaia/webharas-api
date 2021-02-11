package com.webharas.DTO;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="usuario")
public class UsuarioLoginRequestDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private String email;
	
	private String senha;

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
