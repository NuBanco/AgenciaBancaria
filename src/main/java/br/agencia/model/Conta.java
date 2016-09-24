package br.agencia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.agencia.model.enums.TipoConta;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = -5010028474742069862L;

	@Id
	@GeneratedValue
	@Column(name = "con_idconta", columnDefinition = "serial")
	private Integer idConta;

	@Column(name = "con_tipoConta")
	private TipoConta tipoConta;

	@Column(name = "con_numero")
	private String numero;

	@Column(name = "con_dataAbertura")
	private Date dataAbertura;

	@OneToOne
	@JoinColumn(name = "con_idPessoa")
	private Pessoa pessoa;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "con_idagencia")
	private Agencia agencia;

	public Integer getId() {
		return idConta;
	}

	public void setId(Integer idConta) {
		this.idConta = idConta;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	// public BigDecimal getSaldoConta() {
	// return saldoConta;
	// }
	//
	// public void setSaldoConta(BigDecimal saldoConta) {
	// this.saldoConta = saldoConta;
	// }

}
