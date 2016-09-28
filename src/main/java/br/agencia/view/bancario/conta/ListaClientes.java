package br.agencia.view.bancario.conta;

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
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.view.bancario.HomeMenuBancario;
import br.agencia.view.principal.TelaBackground;

public class ListaClientes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbContas;

	public ListaClientes() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		tbContas = new JTable();
		tbContas.setFont(new Font("Arial", Font.PLAIN, 13));
		tbContas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		List<Conta> contas = (List<Conta>) GenericDao.listar("from Conta");

		String coluna[] = { "Tipo Conta", "Agencia", "Numero", "Titular", "Aberta em", "Saldo" };
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		if (contas.size() > 0) {
			contas.forEach(conta -> modelo.addRow(new String[] { conta.getTipoConta().toString(),
					conta.getAgencia().getNumAgencia(), conta.getNumero(), conta.getPessoa().getNome(),
					conta.getDataAbertura().toString(), conta.getSaldo().toString() }));
		}
		tbContas.setModel(modelo);
		scrollPane.setViewportView(tbContas);

		JButton btnImprimir = new JButton("");
		btnImprimir.setFont(new Font("Arial", Font.PLAIN, 18));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap(561, Short.MAX_VALUE)
										.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 44,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVoltar)
										.addContainerGap())
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnImprimir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap(30, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
