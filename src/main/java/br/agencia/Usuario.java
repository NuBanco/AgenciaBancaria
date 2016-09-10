package br.agencia;

public class Usuario {

	private Integer id;
	private String login;
	private String senha;
	private Pessoa pessoa;
	private String senhaOperacao;

	public Integer getId() {
		return id;
	}

	public Usuario setId(Integer id) {
		this.id = id;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Usuario setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}

	public String getSenhaOperacao() {
		return senhaOperacao;
	}

	public void setSenhaOperacao(String senhaOperacao) {
		this.senhaOperacao = senhaOperacao;
	}

}
