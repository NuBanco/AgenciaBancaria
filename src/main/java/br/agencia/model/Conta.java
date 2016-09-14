package br.agencia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.agencia.model.enums.TipoConta;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = -5010028474742069862L;

	@Id
	@GeneratedValue
	@Column(name = "cnt_idconta", columnDefinition = "serial")
	private Integer id;
	
	@Column(name = "cnt_tipoConta")
	private TipoConta tipoConta;
	
	@Column(name = "cnt_agencia")
	private Agencia agencia;
	
	@Column(name = "cnt_numero")
	private String numero;
	
	@Column(name = "cnt_dataAbertura")
	private Date dataAbertura;
	// private BigDecimal saldoConta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
