package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
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

import com.towel.swing.calendar.CalendarView;

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.MovimentoConta;
import br.agencia.view.principal.TelaBackground;

public class Balanco extends JPanel {

	private static final long serialVersionUID = -1100684363335673889L;
	public static final String ID = "BALANCO";
	private JTable table;
	private JTable tbBalanco;
	private JTextField tfAgencia;

	private CalendarView calendarInicial;
	private CalendarView calendarFinal;

	private Agencia agenciaConsultar;
	private JScrollPane scrollPane;
	private List<Conta> contas;
	private List<MovimentoConta> movimentos;

	private BigDecimal totalEntrada;
	private BigDecimal totalSaida;
	private BigDecimal totalMovimentacoes;

	private JLabel lbValorSaida;
	private JLabel lbValorEntrada;
	private JLabel lbValorSaldo;

	public Balanco() {

		TelaBackground.getPanelMenu().add(new JPanel(), SwingConstants.CENTER);

		JButton btnImprimir = new JButton("");
		btnImprimir.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lbSaldoPerodoCaixa = new JLabel("(=)Saldo em Caixa R$");
		lbSaldoPerodoCaixa.setFont(new Font("Arial", Font.BOLD, 14));

		lbValorSaldo = new JLabel("0,00");
		lbValorSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaldo.setFont(new Font("Arial", Font.BOLD, 14));

		lbValorEntrada = new JLabel("0,00");
		lbValorEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorEntrada.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbTotalDepositos = new JLabel("(+) Total ENTRADA R$");
		lbTotalDepositos.setFont(new Font("Arial", Font.BOLD, 14));

		lbValorSaida = new JLabel("0,00");
		lbValorSaida.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaida.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbTotalSaques = new JLabel("(-)Total SAIDA R$");
		lbTotalSaques.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuBancario());
			}
		});

		tfAgencia = new JTextField();
		tfAgencia.setColumns(10);

		JLabel lbConta = new JLabel("Agencia:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 14));

		tbBalanco = new JTable();
		tbBalanco.setFont(new Font("Arial", Font.PLAIN, 13));
		tbBalanco.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agenciaConsultar = (Agencia) ObjectDao.getObjectDao().consultarByQuery(
						String.format("from Agencia where age_numAgencia like '%s'", tfAgencia.getText()));
				if (agenciaConsultar == null) {
					JOptionPane.showMessageDialog(null, "Agencia nao encontrada!");
					return;
				}

				if (calendarInicial.getText().equals("__/__/____")) {
					calendarInicial.setText("01/01/1900");
				}

				if (calendarFinal.getText().equals("__/__/____")) {
					calendarFinal.setText("31/12/2100");
				}

				String dataInicial = getFormatedDate(calendarInicial.getSelectedDate().getTime());
				String dataFinal = getFormatedDate(calendarFinal.getSelectedDate().getTime());

				if (calendarInicial.getSelectedDate().getTime()
						.compareTo(calendarFinal.getSelectedDate().getTime()) >= 0) {
					JOptionPane.showMessageDialog(null, "Data inicial deve ser MENOR que a final!");
					return;
				}
				preencheTabelaBalanco(agenciaConsultar.getId(), dataInicial, dataFinal);

			}
		});

		scrollPane = new JScrollPane();

		calendarInicial = new CalendarView();
		calendarInicial.setTodayString("Hoje");

		calendarFinal = new CalendarView();
		calendarFinal.setTodayString("Hoje");

		JLabel label = new JLabel("< INICIAL");

		JLabel lblFinal = new JLabel("FINAL >");

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		// GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lbConta, GroupLayout.PREFERRED_SIZE, 67,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(tfAgencia, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnConsultar))
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(228).addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(lbValorSaida,
																								GroupLayout.PREFERRED_SIZE,
																								85,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(lbValorEntrada,
																								GroupLayout.PREFERRED_SIZE,
																								85,
																								GroupLayout.PREFERRED_SIZE)))
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(lbTotalSaques)
																				.addComponent(lbTotalDepositos)))
																.addGap(18).addComponent(lbSaldoPerodoCaixa).addGap(99)
																.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE,
																		85, GroupLayout.PREFERRED_SIZE))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(btnImprimir)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnVoltar))
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 666,
																Short.MAX_VALUE))
										.addGap(24))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(calendarInicial, GroupLayout.PREFERRED_SIZE, 172,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label)
												.addComponent(lblFinal))
										.addGap(13).addComponent(calendarFinal, GroupLayout.PREFERRED_SIZE, 172,
												GroupLayout.PREFERRED_SIZE)))));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup().addGap(13).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbConta, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createSequentialGroup().addGap(11).addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout
														.createParallelGroup(Alignment.TRAILING)
														.addComponent(calendarInicial, GroupLayout.PREFERRED_SIZE, 36,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(calendarFinal, GroupLayout.PREFERRED_SIZE, 36,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(label)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblFinal)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lbTotalDepositos, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lbValorEntrada, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lbSaldoPerodoCaixa, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lbTotalSaques, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lbValorSaida, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(53).addComponent(lbValorSaldo,
										GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnImprimir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE))
						.addGap(11)));

		// setLayout(groupLayout);
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

	protected String getFormatedDate(Date date) {
		Date dataSql = date;
		Date dataConvertidaEmUtil = new Date(dataSql.getTime());
		return new SimpleDateFormat("yyyy-MM-dd").format(dataConvertidaEmUtil);
	}

	protected void preencheTabelaBalanco(final int idAgencia, String dataInicial, String dataFinal) {
		String coluna[] = { "Agencia", "Conta", "Operacao", "Valor" };
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		contas = (List<Conta>) ObjectDao.listar(String.format("from Conta where con_idagencia = %d", idAgencia));

		List<Conta> contas = (List<Conta>) ObjectDao
				.listar(String.format("from Conta where con_idagencia = %d", idAgencia));

		movimentos = new ArrayList<>();
		totalEntrada = new BigDecimal(0F);
		totalSaida = new BigDecimal(0F);
		totalMovimentacoes = new BigDecimal(0F);
		if (contas.size() > 0) {
			contas.forEach(conta -> {

				movimentos = (List<MovimentoConta>) ObjectDao.listar(String.format(
						"from MovimentoConta where mov_idconta = %d and mov_dataevento >= '%s' and mov_dataevento <= '%s'",
						conta.getId(), dataInicial, dataFinal));

				if (movimentos.size() > 0) {
					movimentos.forEach(movimento -> {
						if (movimento.getValor().doubleValue() > 0) {
							totalEntrada = totalEntrada.add(movimento.getValor());
						} else {
							totalSaida = totalSaida.add(movimento.getValor());
						}

						modelo.addRow(new String[] { conta.getAgencia().getNome(), conta.getNumero(),
								movimento.getTipoMovimento().name(), movimento.getValor().toString() });
					});
				}
			});
		}
		totalMovimentacoes = totalMovimentacoes.add(totalSaida.add(totalEntrada));

		lbValorSaida.setText(totalSaida.toString());
		lbValorEntrada.setText(totalEntrada.toString());
		lbValorSaldo.setText(totalMovimentacoes.toString());
		tbBalanco.setModel(modelo);

		scrollPane.setViewportView(tbBalanco);
	}
}
