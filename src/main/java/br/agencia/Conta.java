package br.agencia;

import java.math.BigDecimal;
import java.util.Date;

import br.agencia.enums.TipoConta;

public class Conta {

	private Integer id;
	private TipoConta tipoConta;
	private Agencia agencia;
	private String numero;
	private Date dataAbertura;
	private BigDecimal saldoConta;

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

	public BigDecimal getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(BigDecimal saldoConta) {
		this.saldoConta = saldoConta;
	}

}
