package br.agencia.view.bancario;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class Balanco extends JPanel{

	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTable tbGrid;
	public Balanco() {
		
		//teste
		
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
		
		JLabel lblsaldoPerodoR = new JLabel("(=)Saldo em Caixa R$");
		lblsaldoPerodoR.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lbValorSaldo = new JLabel("0,00");
		lbValorSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaldo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tbGrid = new JTable();
		
		JLabel lbValorDepositos = new JLabel("0,00");
		lbValorDepositos.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorDepositos.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lbTotalDepositos = new JLabel("(+) Total Dep\u00F3sitos R$");
		lbTotalDepositos.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lbValorSaques = new JLabel("0,00");
		lbValorSaques.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaques.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lbTotalSaquesR = new JLabel("(-)Total Saques R$");
		lbTotalSaquesR.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox<Object> cbbAgencia = new JComboBox<Object>();
		cbbAgencia.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblAg = new JLabel("Ag\u00EAncia:");
		lblAg.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblAg)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbbAgencia, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnImprimir))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tbGrid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lbTotalSaquesR)
												.addComponent(lbTotalDepositos))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lbValorSaques, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
												.addComponent(lbValorDepositos, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnRegressaAno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnRegressaMes, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnRegressaDia, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtDataInicial, 0, 75, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtDataFinal, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnAvancaDia, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnAvancaMes, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnAvancaAno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblsaldoPerodoR)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))))))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAg)
							.addComponent(cbbAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnImprimir, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbTotalDepositos, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbValorDepositos, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblsaldoPerodoR, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbTotalSaquesR, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbValorSaques, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
		);
		setLayout(groupLayout);
	}
}
