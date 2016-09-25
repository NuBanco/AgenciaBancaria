package br.agencia.model.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.MovimentoConta;
import br.agencia.model.enums.TipoMovimento;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class AtualizarSaldo implements Observable {

	final List<Conta> observers = new ArrayList<>();

	public AtualizarSaldo(Conta conta, BigDecimal valor, TipoMovimento tipoMovimento) {
		MovimentoConta movimento = new MovimentoConta();
		movimento.setValor(valor).setDataEvento(new Date(System.currentTimeMillis())).setTipoMovimento(tipoMovimento).setConta(conta);
		GenericDao.getGenericDao().incluir(movimento);
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// this.observers.add(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		//

	}
}
