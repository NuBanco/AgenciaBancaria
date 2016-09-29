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

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Arial", Font.PLAIN, 15));

		lbValorSaldo = new JLabel("0,00");
		lbValorSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaldo.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSaldoCliente = new JLabel("Saldo Cliente");
		lblSaldoCliente.setFont(new Font("Arial", Font.BOLD, 18));

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
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 15));
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
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 15));
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
		label.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblFinal = new JLabel("FINAL >");
		lblFinal.setFont(new Font("Arial", Font.BOLD, 14));

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		//GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(calendarInicial, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label)
									.addGap(48)
									.addComponent(lblFinal)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSaldoNoPeriodo, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(108)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnConsultar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(calendarFinal, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnImprimir)
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblSaldoCliente))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSaldoCliente)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(calendarInicial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(calendarFinal, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSaldoNoPeriodo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar)
								.addComponent(btnVoltar)
								.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFinal)
								.addComponent(label))))
					.addGap(7))
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
