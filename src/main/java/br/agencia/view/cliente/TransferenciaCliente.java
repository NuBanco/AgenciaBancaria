package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.agencia.view.principal.TelaBackground;

public class TransferenciaCliente extends JPanel {

	private static final long serialVersionUID = 6069759280137589329L;
	private JTextField tfAgencia;
	private JTextField tfConta;
	private JTextField tfTitular;
	private JFormattedTextField tfValor;

	public TransferenciaCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbContaDestino = new JLabel("Conta de destino/Cr\u00E9dito");
		lbContaDestino.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel lbAgencia = new JLabel("Ag\u00EAncia:");
		lbAgencia.setFont(new Font("Arial", Font.BOLD, 16));

		tfAgencia = new JTextField();
		tfAgencia.setFont(new Font("Arial", Font.PLAIN, 16));
		tfAgencia.setColumns(10);

		JLabel TipoConta = new JLabel("Tipo Conta:");
		TipoConta.setFont(new Font("Arial", Font.BOLD, 16));

		JComboBox cbbTipoConta = new JComboBox();
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 16));
		cbbTipoConta.setModel(new DefaultComboBoxModel(
				new String[] { "Conta Corrente", "Conta Poupan\u00E7a", "Conta Eletr\u00F4nica" }));
		cbbTipoConta.setSelectedIndex(0);
		cbbTipoConta.setMaximumRowCount(3);

		tfConta = new JTextField();
		tfConta.setFont(new Font("Arial", Font.PLAIN, 16));
		tfConta.setColumns(10);

		JLabel lbTitular = new JLabel("Titular:");
		lbTitular.setFont(new Font("Arial", Font.BOLD, 16));

		tfTitular = new JTextField();
		tfTitular.setFont(new Font("Arial", Font.PLAIN, 16));
		tfTitular.setColumns(10);

		tfValor = new JFormattedTextField();
		tfValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caractererNumerico = "0987654321.,";
				if (!caractererNumerico.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValor.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbValor = new JLabel("Valor:");
		lbValor.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lbConta = new JLabel("Conta:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(114).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbValor).addComponent(lbTitular, GroupLayout.PREFERRED_SIZE, 137,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(TipoConta, GroupLayout.PREFERRED_SIZE, 151,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbContaDestino, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 586,
										Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING)
										.addComponent(tfTitular, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 468,
												Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(cbbTipoConta, Alignment.LEADING, 0, 300, Short.MAX_VALUE)
												.addComponent(tfAgencia, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														300, Short.MAX_VALUE)
												.addComponent(lbAgencia, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														90, GroupLayout.PREFERRED_SIZE))
												.addGap(27)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lbConta).addComponent(tfConta,
																GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnVoltar).addGap(18)
												.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 113,
														GroupLayout.PREFERRED_SIZE)))
										.addGap(118))
								.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(32)
								.addComponent(lbContaDestino, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lbConta)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(tfConta, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lbAgencia)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfAgencia,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(28).addComponent(TipoConta).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(30).addComponent(lbTitular).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lbValor).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGap(40).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnConfirmar).addComponent(btnVoltar))
								.addContainerGap(30, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}
}
