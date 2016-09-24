package br.agencia.view.bancario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import br.agencia.control.GenericDao;
import br.agencia.model.Agencia;
import br.agencia.view.principal.TelaBackground;

public class ListaAgencia extends JPanel {

	private static final long serialVersionUID = -2810545553216015257L;
	public static final String ID = "LISTAGENCIA";
	private JTable tbAgencia;

	public ListaAgencia() {
		List<Agencia> agencias = new ArrayList<>();

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		agencias = (List<Agencia>) GenericDao.listar("from Agencia");

		tbAgencia = new JTable();
		tbAgencia.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "Nome", "N\u00FAmero", "Cidade" }));

		String coluna[] = { "Nome", "Numero", "Cidade" };

		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		agencias.forEach(agencia -> modelo
				.addRow(new String[] { agencia.getNome(), agencia.getCodAgencia(), agencia.getCidade() }));

		tbAgencia.setModel(modelo);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnAdicionar = new JButton("+");
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new NovaAgencia());
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
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(253, Short.MAX_VALUE)
						.addComponent(btnVoltar).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAdicionar)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addComponent(tbAgencia, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(tbAgencia, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnEditar)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAdicionar)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addGap(15)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
