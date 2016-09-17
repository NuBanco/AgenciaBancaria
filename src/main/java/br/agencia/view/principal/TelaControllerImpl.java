package br.agencia.view.principal;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class TelaControllerImpl implements TelaController {

	private final JPanel panel;
	private final CardLayout card;

	public TelaControllerImpl(JPanel panel, CardLayout card) {
		super();
		this.panel = panel;
		this.card = card;
	}

	@Override
	public void show(final String id) {
		//System.out.println(String.format("Abrindo a tela %s", id));
		this.card.show(this.panel, id);
	}

}
