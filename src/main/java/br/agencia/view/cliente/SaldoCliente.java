package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.MovimentoConta;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.view.principal.TelaBackground;

public class SaldoCliente extends JPanel {

	private static final long serialVersionUID = -7210132078896245655L;
	public static final String ID = "SALDOCLIENTE";
	private JTable tbSaldo;

	List<MovimentoConta> movimentos;
	private JScrollPane scrollPane;
	private BigDecimal saldoCliente;
	private JLabel lbValorSaldo;

	public SaldoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JButton btnImprimir = new JButton("");
		btnImprimir.setFont(new Font("Arial", Font.BOLD, 12));

		lbValorSaldo = new JLabel("0,00");
		lbValorSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaldo.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSaldoCliente = new JLabel("Saldo Cliente");
		lblSaldoCliente.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSaldoNoPeriodo = new JLabel("Saldo periodo:");
		lblSaldoNoPeriodo.setFont(new Font("Arial", Font.BOLD, 17));

		tbSaldo = new JTable();
		tbSaldo.setFont(new Font("Arial", Font.PLAIN, 13));
		tbSaldo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		CalendarView calendarInicial = new CalendarView();
		calendarInicial.setTodayString("Hoje");

		CalendarView calendarFinal = new CalendarView();
		calendarFinal.setTodayString("Hoje");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		scrollPane = new JScrollPane();
		preencheListaMovimento(String.format("from MovimentoConta where mov_idconta = %d",
				UsuarioLogado.getContaUsuarioLogado().getId()));

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calendarInicial.getSelectedDate().getTime()
						.compareTo(calendarFinal.getSelectedDate().getTime()) >= 0) {
					JOptionPane.showMessageDialog(null, "Data inicial deve ser MENOR que a final!");
					return;
				}

				String dataInicial = getFormatedDate(calendarInicial.getSelectedDate().getTime());
				String dataFinal = getFormatedDate(calendarFinal.getSelectedDate().getTime());

				preencheListaMovimento(String.format(
						"from MovimentoConta where mov_idconta = %d and mov_dataevento >= '%s' and mov_dataevento <= '%s'",
						UsuarioLogado.getContaUsuarioLogado().getId(), dataInicial, dataFinal));
			}
		});

		JLabel label = new JLabel("< INICIAL");

		JLabel lblFinal = new JLabel("FINAL >");

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblSaldoCliente)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(calendarInicial, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(label)
									.addComponent(lblFinal))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(calendarFinal, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblSaldoNoPeriodo, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnConsultar)
										.addGap(14)
										.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnImprimir)))
								.addGap(21))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSaldoCliente)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
									.addComponent(lblFinal))
								.addComponent(calendarFinal, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(calendarInicial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(41))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSaldoNoPeriodo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnConsultar)
									.addComponent(btnVoltar))
								.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(19))))
		);
        TelaBackground.getPanelMenu().setLayout(groupLayout);
		//setLayout(groupLayout);
	}

	protected String getFormatedDate(Date date) {
		Date dataSql = date;
		Date dataConvertidaEmUtil = new Date(dataSql.getTime());
		return new SimpleDateFormat("yyyy-MM-dd").format(dataConvertidaEmUtil);
	}

	private void preencheListaMovimento(String query) {
		String coluna[] = { "Operacao", "Data", "Valor" };
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		saldoCliente = new BigDecimal(0F);

		movimentos = (List<MovimentoConta>) ObjectDao.listar(query);
		movimentos.forEach(mov -> {
			saldoCliente = saldoCliente.add(mov.getValor());
			modelo.addRow(new String[] { mov.getTipoMovimento().name(), mov.getDataEvento().toString(),
					mov.getValor().toString() });
		});

		lbValorSaldo.setText(saldoCliente.toString());
		tbSaldo.setModel(modelo);

		scrollPane.setViewportView(tbSaldo);
	}
}
