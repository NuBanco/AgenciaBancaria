package br.agencia.view.bancario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.agencia.control.GenericDao;
import br.agencia.model.Conta;
import br.agencia.view.principal.TelaBackground;

public class ListaClientes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbGrid;

	public ListaClientes() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		tbGrid = new JTable();
		tbGrid.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Tipo Conta", "Agencia", "Numero", "Titular", "Aberta em", "Saldo" }));
		tbGrid.setFont(new Font("Arial", Font.PLAIN, 13));
		tbGrid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbGrid);

		List<Conta> contas = (List<Conta>) GenericDao.listar("from Conta");
		

		JButton btnImprimir = new JButton("");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuBancario());
			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnImprimir)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVoltar).addGap(14)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 208,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 26,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnVoltar))
										.addContainerGap(55, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);

	}

}
