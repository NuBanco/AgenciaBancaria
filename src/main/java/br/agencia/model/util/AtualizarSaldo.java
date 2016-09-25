package br.agencia.model.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.MovimentoConta;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class AtualizarSaldo implements Observable {

	final List<Conta> observers = new ArrayList<>();

	public AtualizarSaldo(Conta conta, BigDecimal valor) {
		MovimentoConta movimento = new MovimentoConta();
		//movimento.se


		GenericDao.getGenericDao().alterar(conta);
	}

	@Override
	public void addListener(InvalidationListener listener) {
		//this.observers.add(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		//

	}
}
