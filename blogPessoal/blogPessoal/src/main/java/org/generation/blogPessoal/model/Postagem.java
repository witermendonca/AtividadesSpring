package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//essa anotação endica essa classe vai ser uma entidadedo jpa
@Entity

//essa anotação essa entidade vira uma tabela com nome postagem
@Table(name = "postagem")

//classe postagem
public class Postagem {

	// esse atributo é um Id
	@Id
	// sera gerado como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// não podera ser nulo
	@NotNull
	// quantidade de caracter para o titulo
	@Size(min = 5, max = 100)
	private String titulo;

	@NotNull
	@Size(min = 10, max = 500)
	private String texto;

	// para data import util.Data, para calcular a data postagem, metodo
	// java.sql.Date
	// para indicar que estamos trabalhando com tempo e tipo de tempo TIMESTAMP
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	// getters e setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
