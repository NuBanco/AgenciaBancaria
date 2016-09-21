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

public class ListaProfissional extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -4635580930027968770L;
	public static final String ID = "LISTPROFISSIONAL";
	private JTable tbProfissionais;

	public ListaProfissional() {

		JPanel panel = new JPanel();

		TelaBackground.getPanelMenu().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tbProfissionais = new JTable();
		tbProfissionais.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Nome", "UserName" }) {
			/**
			 *
			 */
			private static final long serialVersionUID = 4430186584413459932L;
			boolean[] columnEditables = new boolean[] { false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbProfissionais.getColumnModel().getColumn(0).setResizable(false);
		tbProfissionais.getColumnModel().getColumn(0).setPreferredWidth(80);
		tbProfissionais.getColumnModel().getColumn(1).setPreferredWidth(80);

		JButton btnAdicionar = new JButton("+");
		btnAdicionar.setFont(new Font("Arial Black", Font.BOLD, 10));

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(tbProfissionais, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(262, Short.MAX_VALUE)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(tbProfissionais, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}
}
