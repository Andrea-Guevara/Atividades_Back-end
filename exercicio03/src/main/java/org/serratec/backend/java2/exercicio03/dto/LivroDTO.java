package org.serratec.backend.java2.exercicio03.dto;

import java.io.Serializable;
import java.util.Date;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idLivro;
	private String titulo;
	private String tipo;
	private String autor;
	private Date dataDePublicacao;

	public LivroDTO() {
	}

	public LivroDTO(Integer idLivro, String titulo, String tipo, String autor, Date dataDePublicacao) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.tipo = tipo;
		this.autor = autor;
		this.dataDePublicacao = dataDePublicacao;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

}
