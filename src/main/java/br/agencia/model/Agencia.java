package br.agencia.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agencia")
public class Agencia implements Serializable  {

	private static final long serialVersionUID = 2840564797225804733L;

	@Id
	@GeneratedValue
	@Column(name="age_idagencia", columnDefinition = "serial")
	private Integer id;

	@Column(name="age_numAgencia")
	private String codAgencia;

	@Column(name="age_nome")
	private String nome;

	@Column(name="age_cidade")
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
