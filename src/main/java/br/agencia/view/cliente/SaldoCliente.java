package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.MovimentoConta;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.view.principal.TelaBackground;

public class SaldoCliente extends JPanel {

	private static final long serialVersionUID = -7210132078896245655L;
	public static final String ID = "SALDOCLIENTE";
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTable tbSaldo;

	public SaldoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JButton btnRegressaAno = new JButton("I<");
		btnRegressaAno.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnRegressaMes = new JButton("<<");
		btnRegressaMes.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnRegressaDia = new JButton("<");
		btnRegressaDia.setFont(new Font("Arial", Font.BOLD, 12));

		txtDataInicial = new JTextField();
		txtDataInicial.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDataInicial.setEditable(false);
		txtDataInicial.setColumns(10);

		txtDataFinal = new JTextField();
		txtDataFinal.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDataFinal.setEditable(false);
		txtDataFinal.setColumns(10);

		JButton btnAvancaDia = new JButton(">");
		btnAvancaDia.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnAvancaMes = new JButton(">>");
		btnAvancaMes.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnAvancaAno = new JButton(">I");
		btnAvancaAno.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnImprimir = new JButton("");
		btnImprimir.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lbValorSaldo = new JLabel("0,00");
		lbValorSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaldo.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSaldoCliente = new JLabel("Saldo Cliente");
		lblSaldoCliente.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSaldoNoPeriodo = new JLabel("Saldo no periodo:");
		lblSaldoNoPeriodo.setFont(new Font("Arial", Font.BOLD, 17));

		tbSaldo = new JTable();
		tbSaldo.setFont(new Font("Arial", Font.PLAIN, 13));
		tbSaldo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		List<MovimentoConta> movimentos = (List<MovimentoConta>) GenericDao.listar(
				String.format("from MovimentoConta where mov_idconta = %d", UsuarioLogado.getContaUsuarioLogado().getId()));

		String coluna[] = { "Operacao", "Data", "Valor" };
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		movimentos.forEach(
				mov -> modelo.addRow(new String[] { mov.getTipoMovimento().name(), mov.getDataEvento().toString(), mov.getValor().toString() }));

		tbSaldo.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tbSaldo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING).addGroup(
												groupLayout.createSequentialGroup()
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 680,
																Short.MAX_VALUE)
														.addGap(10))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnRegressaAno, GroupLayout.PREFERRED_SIZE, 50,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnRegressaMes, GroupLayout.PREFERRED_SIZE, 50,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnRegressaDia, GroupLayout.PREFERRED_SIZE, 50,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(txtDataInicial,
																				GroupLayout.DEFAULT_SIZE, 168,
																				Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(txtDataFinal,
																				GroupLayout.DEFAULT_SIZE, 160,
																				Short.MAX_VALUE)
																		.addGap(8))
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblSaldoNoPeriodo,
																				GroupLayout.PREFERRED_SIZE, 148,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lbValorSaldo,
																				GroupLayout.PREFERRED_SIZE, 85,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(4)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.TRAILING, false)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(btnAvancaDia,
																				GroupLayout.PREFERRED_SIZE, 50,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnAvancaMes,
																				GroupLayout.PREFERRED_SIZE, 50,
																				GroupLayout.PREFERRED_SIZE))
																.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE,
																		106, GroupLayout.PREFERRED_SIZE)))
												.addComponent(lblSaldoCliente))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnImprimir, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAvancaAno, GroupLayout.DEFAULT_SIZE, 50,
																Short.MAX_VALUE))
												.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblSaldoCliente)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnRegressaAno)
								.addComponent(btnRegressaMes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnRegressaDia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(txtDataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAvancaAno, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
								.addComponent(btnAvancaMes, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
								.addComponent(btnAvancaDia, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
								.addComponent(txtDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
										.addComponent(lblSaldoNoPeriodo, GroupLayout.PREFERRED_SIZE, 14,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(14, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
//		setLayout(groupLayout);
	}
}
