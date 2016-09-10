package br.agencia.telas.bancario;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class ListaAgencia extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2810545553216015257L;
	private JTable tbAgencia;
	public ListaAgencia() {
		
		tbAgencia = new JTable();
		tbAgencia.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nome", "N\u00FAmero", "Cidade"
			}
		));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnAdicionar = new JButton("+");
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(467, Short.MAX_VALUE)
					.addComponent(btnAdicionar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addComponent(tbAgencia, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tbAgencia, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditar)
						.addComponent(btnAdicionar))
					.addGap(15))
		);
		setLayout(groupLayout);
	}
}
