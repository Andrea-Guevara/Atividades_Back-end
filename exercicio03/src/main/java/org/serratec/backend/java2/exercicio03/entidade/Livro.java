package org.serratec.backend.java2.exercicio03.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "biblioteca")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_cd_id")
	private Integer idLivro;

	@NotNull
	@Size(min = 5, max = 30)
	@Column(name = "livro_tx_titulo", nullable = false, length = 30)
	private String titulo;

	@NotNull
	@Size(min = 3, max = 20)
	@Column(name = "livro_tx_tipo", nullable = false, length = 20)
	private String tipo;

	@NotNull
	@Size(min = 10, max = 40)
	@Column(name = "livro_tx_autor")
	private String autor;

	@NotNull
	@Column(name = "livro_data_publicaco")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "A data de publicacao do livro deve estar no passado")
	private Date dataDePublicacao;

	public Livro() {
	}

	public Livro(Integer idLivro, @NotNull @Size(min = 5, max = 30) String titulo,
			@NotNull @Size(min = 3, max = 20) String tipo, @NotNull @Size(min = 10, max = 40) String autor,
			@NotNull Date dataDePublicacao) {
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
