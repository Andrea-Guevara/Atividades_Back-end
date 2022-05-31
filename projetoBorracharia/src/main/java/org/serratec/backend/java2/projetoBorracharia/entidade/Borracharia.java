package org.serratec.backend.java2.projetoBorracharia.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "borracharia")
public class Borracharia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "borracharia_cd_id")
	private Integer idBorracharia;

	@Column(name = "borracharia_tx_valor")
	@NotNull
	private Double valor;

	@Column(name = "borracharia_tx_tipoServico")
	@NotNull
	private String tipoDeServico;

	@Column(name = "borracharia_dt_servico")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	@ManyToOne
	@JoinColumn(name = "id_carro", referencedColumnName = "carro_cd_id")
	private Carro carro;

	public Borracharia() {
	}

	public Borracharia(Integer idBorracharia, @NotNull Double valor, @NotNull String tipoDeServico, Date data,
			Carro carro) {
		super();
		this.idBorracharia = idBorracharia;
		this.valor = valor;
		this.tipoDeServico = tipoDeServico;
		this.data = data;
		this.carro = carro;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
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

	public String getTipoDeServico() {
		return tipoDeServico;
	}

	public void setTipoDeServico(String tipoDeServico) {
		this.tipoDeServico = tipoDeServico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
