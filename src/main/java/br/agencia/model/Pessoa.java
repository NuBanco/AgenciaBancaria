package br.agencia.model;

public class Pessoa {

	private Integer id;
	private String nome;
	private Integer idade;
	private String senha;
	private String cpf;

	public Integer getIdade() {
		return idade;
	}

	public Pessoa setIdade(Integer idade) {
		this.idade = idade;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Pessoa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Pessoa setSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Pessoa setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCpf() {
		return cpf;
	}

	public Pessoa setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

}