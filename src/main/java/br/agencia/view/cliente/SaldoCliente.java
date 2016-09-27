package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.towel.swing.calendar.CalendarView;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.MovimentoConta;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.view.principal.TelaBackground;

public class SaldoCliente extends JPanel {

	private static final long serialVersionUID = -7210132078896245655L;
	public static final String ID = "SALDOCLIENTE";
	private JTable tbSaldo;

	List<MovimentoConta> movimentos;

	public SaldoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

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

		CalendarView calendarFinal = new CalendarView();

		JLabel lblDataFinal = new JLabel("ATE");
		lblDataFinal.setFont(new Font("Arial", Font.BOLD, 17));

		CalendarView calendarInicial = new CalendarView();
		JLabel lblDataIncial = new JLabel("DE");
		lblDataIncial.setFont(new Font("Arial", Font.BOLD, 17));

		movimentos = preencheListaMovimento(String.format("from MovimentoConta where mov_idconta = %d",
				UsuarioLogado.getContaUsuarioLogado().getId()));

		String coluna[] = { "Operacao", "Data", "Valor" };
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		movimentos.forEach(mov -> modelo.addRow(new String[] { mov.getTipoMovimento().name(),
				mov.getDataEvento().toString(), mov.getValor().toString() }));

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

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataInicial = calendarInicial.getSelectedDate().getTime();
				Date dataFinal = calendarFinal.getSelectedDate().getTime();

				movimentos.clear();
				movimentos = preencheListaMovimento(
						"from MovimentoConta where mov_idconta = " + UsuarioLogado.getContaUsuarioLogado().getId()
								+ " and mov_dataevento >= " + dataInicial + " and mov_dataevento <= " + dataFinal);
			}
		});

		// GroupLayout groupLayout = new GroupLayout(this);
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
														.createSequentialGroup()
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 682,
																Short.MAX_VALUE)
														.addGap(10))
												.addGroup(groupLayout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE)
														.addComponent(lblDataIncial, GroupLayout.PREFERRED_SIZE, 31,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(calendarInicial, GroupLayout.PREFERRED_SIZE, 152,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblDataFinal)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup().addGap(98)
																		.addComponent(lblSaldoCliente))
																.addGroup(groupLayout.createSequentialGroup()
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(calendarFinal,
																								GroupLayout.PREFERRED_SIZE,
																								155,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(lblSaldoNoPeriodo,
																								GroupLayout.PREFERRED_SIZE,
																								148,
																								GroupLayout.PREFERRED_SIZE))
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addGap(69)
																						.addComponent(btnConsultar)))
																		.addGap(8)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addGap(30)
																						.addComponent(btnVoltar,
																								GroupLayout.PREFERRED_SIZE,
																								61,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(btnImprimir))
																				.addComponent(lbValorSaldo,
																						GroupLayout.PREFERRED_SIZE, 85,
																						GroupLayout.PREFERRED_SIZE))))
														.addContainerGap()))));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addContainerGap().addComponent(lblSaldoCliente)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(calendarFinal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblDataFinal, Alignment.TRAILING)
										.addComponent(lblDataIncial, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(calendarInicial, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(16)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSaldoNoPeriodo, GroupLayout.PREFERRED_SIZE, 14,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVoltar).addComponent(btnConsultar))
						.addGap(12)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
		// setLayout(groupLayout);
	}

	private List<MovimentoConta> preencheListaMovimento(String query) {
		return (List<MovimentoConta>) GenericDao.listar(query);
	}
}
