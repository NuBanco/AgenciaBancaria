package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.agencia.view.principal.TelaBackground;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaldoCliente extends JPanel{

	private static final long serialVersionUID = -7210132078896245655L;
	public static final String ID = "SALDOCLIENTE";
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTable tbGrid;
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
		
		tbGrid = new JTable();
		
		JLabel lblSaldoCliente = new JLabel("Saldo Cliente");
		lblSaldoCliente.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(lblSaldoCliente)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnImprimir))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tbGrid, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnRegressaAno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRegressaMes, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRegressaDia, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDataInicial, 0, 75, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(117)
											.addComponent(btnVoltar)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtDataFinal, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnAvancaDia, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnAvancaMes, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnAvancaAno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSaldoCliente))
						.addComponent(btnImprimir, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbGrid, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegressaAno, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
						.addComponent(btnRegressaMes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRegressaDia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtDataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAvancaDia, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
						.addComponent(btnAvancaMes, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
						.addComponent(btnAvancaAno, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVoltar))
					.addGap(20))
		);
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}
}
