package br.agencia.model.entidadesPersistidas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimento")
public class MovimentoConta implements Serializable {

	private static final long serialVersionUID = 4502731648071395420L;

	@Id
	@GeneratedValue
	@Column(name = "mov_idmovimento", columnDefinition = "serial")
	private Integer idMovimento;

	@Column(name = "mov_tipoMovimento")
	private String tipoMovimento;

	@Column(name = "mov_dataEvento")
	private Date dataEvento;

	@Column(name = "mov_horaEvento")
	private Time horaEvento;

	@Column(name = "mov_valor")
	private BigDecimal valor;

	@OneToOne
	@JoinColumn(name = "mov_idconta")
	private Conta conta;

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public MovimentoConta setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
		return this;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public MovimentoConta setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
		return this;
	}

	public Time getHoraEvento() {
		return horaEvento;
	}

	public MovimentoConta setHoraEvento(Time horaEvento) {
		this.horaEvento = horaEvento;
		return this;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public MovimentoConta setValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}
}
