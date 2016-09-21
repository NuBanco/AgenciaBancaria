package br.agencia.view.bancario;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import br.agencia.view.principal.TelaBackground;

public class ListaAgencia extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -2810545553216015257L;
	public static final String ID = "LISTAGENCIA";
	private JTable tbAgencia;

	public ListaAgencia() {

		JPanel panel = new JPanel();

		TelaBackground.getPanelMenu().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tbAgencia = new JTable();
		tbAgencia.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Nome", "N\u00FAmero", "Cidade" }));

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnAdicionar = new JButton("+");
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(467, Short.MAX_VALUE)
								.addComponent(btnAdicionar).addPreferredGap(ComponentPlacement.RELATED).addComponent(
										btnEditar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addComponent(tbAgencia, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup()
												.addComponent(tbAgencia, GroupLayout.PREFERRED_SIZE, 220,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnEditar).addComponent(btnAdicionar))
												.addGap(15)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
