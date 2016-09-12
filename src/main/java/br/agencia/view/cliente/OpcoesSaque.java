package br.agencia.view.cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.view.main.TelaBackground;

import javax.swing.SwingConstants;

public class OpcoesSaque extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2914438307389368709L;

	public OpcoesSaque() {

		JButton btnOp50 = new JButton("R$ 50,00");
		btnOp50.setFont(new Font("Arial", Font.BOLD, 17));
		btnOp50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(50.00));
			}
		});

		JButton btnOp100 = new JButton("R$ 100,00");
		btnOp100.setFont(new Font("Arial", Font.BOLD, 17));
		btnOp100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(50.00));
			}
		});
		
		JButton btnOp500 = new JButton("R$ 500,00");
		btnOp500.setFont(new Font("Arial", Font.BOLD, 17));
		btnOp500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(50.00));
			}
		});
		
		JFormattedTextField txtValor = new JFormattedTextField();
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setText("R$ 0,00");		

		JButton btnConfirme = new JButton("Confirme");
		btnConfirme.setFont(new Font("Arial", Font.BOLD, 14));
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(txtValor.getText()));
			}
		});

		JButton btnOp300 = new JButton("R$ 300,00");
		btnOp300.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOp200 = new JButton("R$ 200,00");
		btnOp200.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lbValorEspecifico = new JLabel("Informe outro valor:");
		lbValorEspecifico.setFont(new Font("Arial", Font.BOLD, 14));

		txtValor.setFont(new Font("Arial", Font.PLAIN, 16));
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setText("R$ 0,00");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnOp500, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOp100, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOp50, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnOp200, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnOp300, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbValorEspecifico)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnConfirme, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))))
					.addGap(88))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOp50, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOp200, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOp100, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOp300, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnOp500, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbValorEspecifico)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConfirme, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	private void OpcaoSacar( BigDecimal valor ){
		TelaBackground saldo = null;
		saldo = new TelaBackground(new ConfirmaOperacao(saldo));
		saldo.setSize(580, 470);
		saldo.setLocationRelativeTo(null);
		saldo.setVisible(true);					
	}
}
