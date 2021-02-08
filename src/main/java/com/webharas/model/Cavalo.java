package com.webharas.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cavalo")
public class Cavalo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String preco;
	
	private Date dtnasc;
	
	private String descricao;
	
	private Long genero_id;
	
	private Long habilidade_id;
	
	private Long video_id;
		
	private Long cidade_id;
	
	private Long usuario_id;
	
	private Long linhagem_id;
	
	private Long haras_id;
	
	private Long raca_id;
	
	private Long pelagem_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Date getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getGenero_id() {
		return genero_id;
	}

	public void setGenero_id(Long genero_id) {
		this.genero_id = genero_id;
	}

	public Long getHabilidade_id() {
		return habilidade_id;
	}

	public void setHabilidade_id(Long habilidade_id) {
		this.habilidade_id = habilidade_id;
	}

	public Long getVideo_id() {
		return video_id;
	}

	public void setVideo_id(Long video_id) {
		this.video_id = video_id;
	}

	public Long getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Long cidade_id) {
		this.cidade_id = cidade_id;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Long getLinhagem_id() {
		return linhagem_id;
	}

	public void setLinhagem_id(Long linhagem_id) {
		this.linhagem_id = linhagem_id;
	}

	public Long getHaras_id() {
		return haras_id;
	}

	public void setHaras_id(Long haras_id) {
		this.haras_id = haras_id;
	}

	public Long getRaca_id() {
		return raca_id;
	}

	public void setRaca_id(Long raca_id) {
		this.raca_id = raca_id;
	}

	public Long getPelagem_id() {
		return pelagem_id;
	}

	public void setPelagem_id(Long pelagem_id) {
		this.pelagem_id = pelagem_id;
	}
	
	

}
