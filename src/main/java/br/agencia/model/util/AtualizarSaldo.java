package br.agencia.model.util;

import java.util.ArrayList;
import java.util.List;

import br.agencia.model.entidadesPersistidas.Conta;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class AtualizarSaldo implements Observable {

	final List<Conta> observers = new ArrayList<>();

	@Override
	public void addListener(InvalidationListener listener) {
		this.observers.add(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		//

	}
}
