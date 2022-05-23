package org.serratec.backend.java2.exercicio2.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_cd_conta")
	private Integer idConta;

	@Column(name = "conta_nu_numero")
	private String numeroDaConta;

	@Column(name = "conta_tx_titular")
	private String titular;

	@Column(name = "conta_tx_saldo")
	private String saldo;

	public Conta() {
	}

	public Conta(Integer idConta, String numeroDaConta, String titular, String saldo) {
		super();
		this.idConta = idConta;
		this.numeroDaConta = numeroDaConta;
		this.titular = titular;
		this.saldo = saldo;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

}
