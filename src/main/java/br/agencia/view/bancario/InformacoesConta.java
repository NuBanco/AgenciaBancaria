package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.model.util.OperacoesFacade;

public class InformacoesConta extends JFrame {

	private static final long serialVersionUID = -8293231784772338084L;
	private JTextField tfAgencia;
	private JTextField tfConta;
	private JTextField tfTipoConta;
	private JTextField tfTitular;
	public static final String ID = "INFCONTA";

	public InformacoesConta() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lbAgncia = new JLabel("Ag\u00EAncia:");
		lbAgncia.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbTitular = new JLabel("Titular:");
		lbTitular.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbConta = new JLabel("Conta:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 16));

		tfAgencia = new JTextField();
		tfAgencia.setFont(new Font("Arial", Font.PLAIN, 16));
		tfAgencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		tfAgencia.setColumns(10);

		tfConta = new JTextField();
		tfConta.setFont(new Font("Arial", Font.PLAIN, 16));
		tfConta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		tfConta.setColumns(10);

		tfTipoConta = new JTextField();
		tfTipoConta.setFont(new Font("Arial", Font.PLAIN, 16));

		tfTitular = new JTextField();
		tfTitular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfTitular.setColumns(10);

		JButton btnConfirme = new JButton("Confirmar");
		btnConfirme.setFont(new Font("Arial", Font.PLAIN, 18));
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperacoesFacade operacoesFacade = new OperacoesFacade();
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(30).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lbAgncia)
										.addComponent(tfAgencia, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
								.addGap(28)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lbConta, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfConta, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
						.addComponent(btnConfirme, Alignment.TRAILING).addComponent(lbTipoConta).addComponent(lbTitular)
						.addComponent(tfTipoConta, 0, 313, Short.MAX_VALUE)
						.addComponent(tfTitular, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)).addGap(27)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(29)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lbAgncia)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfAgencia,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lbConta)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfConta,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbTipoConta).addGap(3)
						.addComponent(tfTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lbTitular).addGap(2)
						.addComponent(tfTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnConfirme)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
	}
}
