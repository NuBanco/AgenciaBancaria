package br.agencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Agencia implements Serializable  {

	private static final long serialVersionUID = 2840564797225804733L;
	
	@Id
	@GeneratedValue
	@Column(name="ag_idagencia")
	private Integer id;
	
	@Column(name="ag_codAgencia")
	private String codAgencia;
	
	@Column(name="ag_nome")
	private String nome;
	
	@Column(name="ag_cidade")
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
