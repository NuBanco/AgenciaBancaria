package br.agencia.model;

public class Agencia {

	private Integer id;
	private String codAgencia;
	private String nome;
	private String cidade;

	public Integer getId() {
		return id;
	}

	public Agencia setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Agencia setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public Agencia setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getCodAgencia() {
		return codAgencia;
	}

	public Agencia setCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
		return this;
	}

}
