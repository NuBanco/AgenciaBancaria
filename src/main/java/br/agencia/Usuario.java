package br.agencia;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.agencia.enums.TipoUsuario;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 6811212106974636541L;

	@Id
	@GeneratedValue
	@Column(name="idusuario")
	private Integer idUsuario;

	@Column(name="usu_login")
	private String login;

	@Column(name="usu_senha")
	private String senha;

	@Column(name="usu_senhaOperacao")
	private String senhaOperacao;

	@Column(name="usu_tipousuario")
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
