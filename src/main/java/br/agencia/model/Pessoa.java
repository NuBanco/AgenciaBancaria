package br.agencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -2649068654653715106L;

	@Id
	@GeneratedValue
	@Column(name = "ps_idpessoa")
	private Integer id;

	@Column(name = "ps_nome")
	private String nome;

	@Column(name = "ps_idade")
	private Integer idade;

	@Column(name = "ps_senha")
	private String senha;

	@Column(name = "ps_cpf")
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