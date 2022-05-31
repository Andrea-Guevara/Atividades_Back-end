package org.serratec.backend.java2.projetoBorracharia.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carro")
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carro_cd_id")
	private Integer idCarro;

	@Column(name = "carro_tx_modelo")
	@NotNull
	private String modelo;

	@Column(name = "carro_tx_marca")
	@NotNull
	private String marca;

	@Column(name = "carro_num_ano")
	@NotNull
	private int ano;

	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_cd_id")
	private Cliente cliente;

	@OneToMany(mappedBy = "carro")
	private List<Borracharia> listaDeServicos;

	public Carro() {
	}

	public Carro(Integer idCarro, @NotNull String modelo, @NotNull String marca, @NotNull int ano,
			@NotNull String tipoDeServico, Cliente cliente, List<Borracharia> listaDeServicos) {
		super();
		this.idCarro = idCarro;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.cliente = cliente;
		this.listaDeServicos = listaDeServicos;
	}

	public List<Borracharia> getListaDeServicos() {
		return listaDeServicos;
	}

	public void setListaDeServicos(List<Borracharia> listaDeServicos) {
		this.listaDeServicos = listaDeServicos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	
}
