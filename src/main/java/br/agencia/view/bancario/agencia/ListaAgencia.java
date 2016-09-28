package br.agencia.view.bancario.agencia;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.view.bancario.HomeMenuBancario;
import br.agencia.view.principal.TelaBackground;

public class ListaAgencia extends JPanel {

	private static final long serialVersionUID = -2810545553216015257L;
	public static final String ID = "LISTAGENCIA";
	JScrollPane scrollPane = new JScrollPane();
	private JTable tbAgencia;

	public ListaAgencia() {

		List<Agencia> agencias = new ArrayList<>();

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		agencias = (List<Agencia>) ObjectDao.listar("from Agencia");

		tbAgencia = new JTable();
		tbAgencia.setFont(new Font("Arial", Font.PLAIN, 13));
		tbAgencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String coluna[] = { "Nome", "Numero", "Cidade" };
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		agencias.forEach(agencia -> modelo
				.addRow(new String[] { agencia.getNome(), agencia.getNumAgencia(), agencia.getCidade() }));

		tbAgencia.setModel(modelo);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbAgencia.getSelectedRow() != -1) {
					TelaBackground.clearPanelMenu();
					Agencia agenciaEditar = (Agencia) ObjectDao
							.consultarByQuery(String.format("from Agencia where age_numAgencia like '%s'",
									tbAgencia.getValueAt(tbAgencia.getSelectedRow(), 1)));
					TelaBackground.getPanelMenu().add(new CadastroAgencia(agenciaEditar));
				}
			}
		});

		JButton btnAdicionar = new JButton("+");
		btnAdicionar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new CadastroAgencia(new Agencia()));
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuBancario());
			}
		});

		scrollPane.setViewportView(tbAgencia);

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 680,
										Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup().addComponent(btnVoltar)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAdicionar)))
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 343,
												GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnEditar).addComponent(btnAdicionar))
										.addGap(37)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
