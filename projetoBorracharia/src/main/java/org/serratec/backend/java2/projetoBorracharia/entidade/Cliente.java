package org.serratec.backend.java2.projetoBorracharia.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_cd_id")
	private Integer idCliente;

	@Column(name = "cliente_tx_nome")
	@NotNull
	private String nome;

	@Column(name = "cliente_tx_cpf")
	@NotNull
	private String cpf;

	@Column(name = "cliente_num_telefone")
	@NotNull
	private String numeroDeTelefone;

	@Column(name = "cliente_tx_gmail")
	@NotNull
	private String gmail;

	@OneToMany(mappedBy = "cliente")
	private List<Carro> listaCarro;

	public Cliente() {
	}

	public List<Carro> getListaCarro() {
		return listaCarro;
	}

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroDeTelefone() {
		return numeroDeTelefone;
	}

	public void setNumeroDeTelefone(String numeroDeTelefone) {
		this.numeroDeTelefone = numeroDeTelefone;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

}
