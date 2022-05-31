package org.serratec.backend.java2.projetoBorracharia.dto;

public class ClienteDTO {
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String numeroDeTelefone;
	private String gmail;
	
	public ClienteDTO() {}

	public ClienteDTO(Integer idCliente, String nome, String cpf, String numeroDeTelefone, String gmail) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.numeroDeTelefone = numeroDeTelefone;
		this.gmail = gmail;
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
