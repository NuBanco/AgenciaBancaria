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

public class TransferenciaCliente extends JPanel{

	private static final long serialVersionUID = 6069759280137589329L;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	private JFormattedTextField txtValor;

	public TransferenciaCliente(){
		
		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lblContaDestino = new JLabel("Conta de destino/Cr\u00E9dito");
		lblContaDestino.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblAgencia = new JLabel("AG:");
		lblAgencia.setFont(new Font("Arial", Font.BOLD, 14));

		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAgencia.setColumns(10);

		JLabel TipoConta = new JLabel("Tipo Conta:");
		TipoConta.setFont(new Font("Arial", Font.BOLD, 14));

		JComboBox cbbTipoConta = new JComboBox();
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 14));
		cbbTipoConta.setModel(new DefaultComboBoxModel(new String[] {"Conta Corrente", "Conta Poupan\u00E7a", "Conta Eletr\u00F4nica"}));
		cbbTipoConta.setSelectedIndex(0);
		cbbTipoConta.setMaximumRowCount(3);

		txtConta = new JTextField();
		txtConta.setFont(new Font("Arial", Font.PLAIN, 14));
		txtConta.setColumns(10);

		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setFont(new Font("Arial", Font.BOLD, 14));

		txtTitular = new JTextField();
		txtTitular.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTitular.setColumns(10);

		txtValor = new JFormattedTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caractererNumerico = "0987654321.";
				if (!caractererNumerico.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtValor.setText("0.00");
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblConta = new JLabel("Conta:");
		lblConta.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(TipoConta, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitular, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTitular, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(lblValor)
								.addComponent(txtValor))
							.addGap(18)
							.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVoltar)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblContaDestino, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(281))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAgencia, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConta)
								.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(216, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblContaDestino, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAgencia)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblConta)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addComponent(TipoConta)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTitular)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblValor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(254, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnVoltar))
					.addGap(21))
		);
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
