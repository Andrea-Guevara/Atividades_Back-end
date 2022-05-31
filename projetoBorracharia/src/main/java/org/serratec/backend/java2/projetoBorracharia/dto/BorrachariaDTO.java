package org.serratec.backend.java2.projetoBorracharia.dto;

import java.util.Date;

public class BorrachariaDTO {

	private Integer idBorracharia;
	private Double valor;
	private Date data;
	private String tipoDeServico;
	private Integer idCarro;

	public BorrachariaDTO() {
	}

	public BorrachariaDTO(Integer idBorracharia, Double valor, Date data, String tipoDeServico, Integer idCarro) {
		super();
		this.idBorracharia = idBorracharia;
		this.valor = valor;
		this.data = data;
		this.tipoDeServico = tipoDeServico;
		this.idCarro = idCarro;
	}

	public Integer getIdBorracharia() {
		return idBorracharia;
	}

	public void setIdBorracharia(Integer idBorracharia) {
		this.idBorracharia = idBorracharia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipoDeServico() {
		return tipoDeServico;
	}

	public void setTipoDeServico(String tipoDeServico) {
		this.tipoDeServico = tipoDeServico;
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

}
