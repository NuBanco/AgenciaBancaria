package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

		CalendarView calendarInicial = new CalendarView();
		calendarInicial.setTodayString("Hoje");
		CalendarView calendarFinal = new CalendarView();
		calendarFinal.setTodayString("Hoje");

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
				if (calendarInicial.getSelectedDate().getTime().compareTo(calendarFinal.getSelectedDate().getTime()) >= 0) {
					JOptionPane.showMessageDialog(null, "Data inicial deve ser MENOR que a final!");
					return;
				}

				String dataInicial = getFormatedDate(calendarInicial.getSelectedDate().getTime());
				String dataFinal = getFormatedDate(calendarFinal.getSelectedDate().getTime());

				movimentos = new ArrayList<>();
				movimentos = preencheListaMovimento(String.format(
						"from MovimentoConta where mov_idconta = %d and mov_dataevento >= '%s' and mov_dataevento <= '%s'",
						UsuarioLogado.getContaUsuarioLogado().getId(), dataInicial, dataFinal));

				movimentos.forEach(mov -> modelo.addRow(new String[] { mov.getTipoMovimento().name(), mov.getDataEvento().toString(),
							mov.getValor().toString() } ));

				tbSaldo.setModel(modelo);
				scrollPane.setViewportView(tbSaldo);
			}
		});

		JLabel label = new JLabel("< INICIAL");

		JLabel lblFinal = new JLabel("FINAL >");

		// GroupLayout groupLayout = new GroupLayout(this);
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(
						Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE).addGap(10))
						.addGroup(groupLayout.createSequentialGroup().addGap(170)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label)
										.addComponent(lblFinal))
								.addGap(6)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup().addGap(98)
												.addComponent(lblSaldoCliente))
										.addGroup(groupLayout.createSequentialGroup().addGap(3)
												.addComponent(
														calendarFinal, GroupLayout.PREFERRED_SIZE, 173,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(btnConsultar)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 61,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(btnImprimir))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblSaldoNoPeriodo,
																		GroupLayout.PREFERRED_SIZE, 148,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE,
																		85, GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(calendarInicial, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(530, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblSaldoCliente)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE).addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup().addGap(16)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSaldoNoPeriodo, GroupLayout.PREFERRED_SIZE, 14,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(calendarFinal, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
										.addComponent(calendarInicial, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(label)
														.addPreferredGap(ComponentPlacement.RELATED, 13,
																Short.MAX_VALUE)
														.addComponent(lblFinal)))))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnVoltar)
								.addComponent(btnConsultar)))
				.addContainerGap()));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
		// setLayout(groupLayout);
	}

	protected String getFormatedDate(Date date) {
		Date dataSql = date;
		Date dataConvertidaEmUtil = new Date(dataSql.getTime());
		return new SimpleDateFormat("yyyy-MM-dd").format(dataConvertidaEmUtil);
	}

	private List<MovimentoConta> preencheListaMovimento(String query) {
		return (List<MovimentoConta>) GenericDao.listar(query);
	}
}
