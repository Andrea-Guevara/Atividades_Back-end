package org.serratec.java.backend.exercicio01.Entidade;

public class DocePadaria {
	private Integer id;
	private String tipoDeDoce;
	private String preco;
	private String descricao;

	public DocePadaria() {
	}

	public DocePadaria(Integer id, String tipoDeDoce, String preco, String descricao) {
		super();
		this.id = id;
		this.tipoDeDoce = tipoDeDoce;
		this.preco = preco;
		this.descricao = descricao;
	}

	public String getTipoDeDoce() {
		return tipoDeDoce;
	}

	public void setTipoDeDoce(String tipoDeDoce) {
		this.tipoDeDoce = tipoDeDoce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
