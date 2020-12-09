package com.generation.livecode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_live_code")
public class LiveCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Min(0)
	@Column(name = "qtd_participantes")
	private long qtdParticipantes;
	
	@NotBlank
	@Size(min = 3, max = 99)
	private String titulo;
	
	@NotBlank
	@Size(min = 3, max = 99)
	private String plataforma;
	
	private boolean convidade;
	
	private boolean ativo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQtdParticipantes() {
		return qtdParticipantes;
	}

	public void setQtdParticipantes(long qtdParticipantes) {
		this.qtdParticipantes = qtdParticipantes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isConvidade() {
		return convidade;
	}

	public void setConvidade(boolean convidade) {
		this.convidade = convidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
