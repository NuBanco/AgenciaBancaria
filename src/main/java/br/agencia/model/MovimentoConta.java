package br.agencia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class MovimentoConta {

	@Entity
	@Table(name = "movimento")
	public class MovimentacaoConta implements Serializable {

		private static final long serialVersionUID = 4502731648071395420L;
		@Id
		@GeneratedValue
		@Column(name = "mvt_idMovimento", columnDefinition = "serial")
		private Integer idMovimento;
		@Column(name = "mvt_conta")
		private Conta conta;
		@Column(name = "mvt_tipoMovimento")
		private String tipoMovimento;
		@Column(name = "mvt_dataEvento")
		private Date dataEvento;
		@Column(name = "mvt_horaEvento")
		private Time horaEvento;
		@Column(name = "mvt_valor")
		private BigDecimal valor;
		@Column(name = "mvt_descricao")
		private String descricaoOperacao;

		public Conta getConta() {
			return conta;
		}

		public MovimentacaoConta setConta(Conta conta) {
			this.conta = conta;
			return this;
		}

		public String getTipoMovimento() {
			return tipoMovimento;
		}

		public MovimentacaoConta setTipoMOvimento(String tipoMovimento) {
			this.tipoMovimento = tipoMovimento;
			return this;
		}

		public Date getDataEvento() {
			return dataEvento;
		}

		public MovimentacaoConta setDataEvento(Date dataEvento) {
			this.dataEvento = dataEvento;
			return this;
		}

		public Time getHoraEvento() {
			return horaEvento;
		}

		public MovimentacaoConta setHoraEvento(Time horaEvento) {
			this.horaEvento = horaEvento;
			return this;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public MovimentacaoConta setValor(BigDecimal valor) {
			this.valor = valor;
			return this;
		}

		public String getDescricaoOperacao() {
			return descricaoOperacao;
		}

		public MovimentacaoConta setDescricaoOperacao(String descricaoOperacao) {
			this.descricaoOperacao = descricaoOperacao;
			return this;
		}
	}

}
