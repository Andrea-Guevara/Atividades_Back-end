package org.serratec.backend.java2.projetoBorracharia.dto;

public class CarroDTO {

	private Integer idCarro;
	private String modelo;
	private String marca;
	private int ano;
	private Integer idCliente;

// contrutores

	public CarroDTO() {
	}

	public CarroDTO(Integer idCarro, String modelo, String marca, int ano, String tipoDeServico, Integer idCliente) {
		super();
		this.idCarro = idCarro;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.idCliente = idCliente;
	}

// getters e setters
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

	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
