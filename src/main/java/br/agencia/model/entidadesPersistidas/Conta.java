package br.agencia.model.entidadesPersistidas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Observable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.agencia.control.GenericDao;
import br.agencia.model.enums.SituacaoConta;
import br.agencia.model.enums.TipoConta;
import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.AtualizarSaldo;

@Entity
@Table(name = "conta")
public class Conta extends Observable implements Serializable {

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

	@Column(name = "con_situacao")
	private SituacaoConta situacaoConta;

	@Column(name = "con_saldo")
	private BigDecimal saldo;

	@OneToOne
	@JoinColumn(name = "con_idPessoa")
	private Pessoa pessoa;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "con_idagencia")
	private Agencia agencia;

	public Integer getId() {
		return idConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Conta setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}

	public Conta setId(Integer idConta) {
		this.idConta = idConta;
		return this;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public Conta setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
		return this;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public Conta setAgencia(Agencia agencia) {
		this.agencia = agencia;
		return this;
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

	public Conta setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
		return this;
	}

	public SituacaoConta getSituacaoConta() {
		return situacaoConta;
	}

	public Conta setSituacaoConta(SituacaoConta situacaoConta) {
		this.situacaoConta = situacaoConta;
		return this;
	}

	public BigDecimal getSaldo() {
		if (saldo == null) {
			saldo = new BigDecimal(0F);
		}
		return saldo;
	}

	public Conta setSaldo(BigDecimal valor) {
		if (saldo == null) {
			saldo = new BigDecimal(0F);
		}

		this.saldo.add(valor);
		return this;
	}

	public Conta setSaldo(BigDecimal valor, TipoMovimento tipoMovimento) {
		if (saldo == null) {
			saldo = new BigDecimal(0F);
		}

		BigDecimal saldoAuxiliar = new BigDecimal(0F);

		this.saldo = saldo.add(saldoAuxiliar.add(valor));

		GenericDao.getGenericDao().alterar(this);
		new AtualizarSaldo(this, valor, tipoMovimento);

		setChanged();
		notifyObservers();

		return this;
	}
}
