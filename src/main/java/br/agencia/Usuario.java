package br.agencia;

import br.agencia.enums.TipoUsuario;

public class Usuario {

	private Integer idUsuario;
	private String login;
	private String senha;
	private String senhaOperacao;
	private TipoUsuario tipoUsuario;

	public Integer getId() {
		return idUsuario;
	}

	public Usuario setId(Integer id) {
		this.idUsuario = id;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public Usuario setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario setSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public String getSenhaOperacao() {
		return senhaOperacao;
	}

	public void setSenhaOperacao(String senhaOperacao) {
		this.senhaOperacao = senhaOperacao;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public Usuario setTipoUsuario(TipoUsuario usuario) {
		this.tipoUsuario = usuario;
		return this;
	}

}
