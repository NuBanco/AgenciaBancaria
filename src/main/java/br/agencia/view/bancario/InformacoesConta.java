package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InformacoesConta extends JFrame {

	private static final long serialVersionUID = -8293231784772338084L;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	public static final String ID = "INFCONTA";

	public InformacoesConta() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAgencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321-";
				if(!caracteres.contains(e.getKeyChar()+"")){
					e.consume();
				}							
			}
		});
		txtAgencia.setColumns(10);

		JLabel lbAgncia = new JLabel("AG:");
		lbAgncia.setFont(new Font("Arial", Font.BOLD, 14));
		

		txtConta = new JTextField();
		txtConta.setFont(new Font("Arial", Font.PLAIN, 14));
		txtConta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321-";
				if(!caracteres.contains(e.getKeyChar()+"")){
					e.consume();
				}							
			}
		});
		txtConta.setColumns(10);

		JLabel lbConta = new JLabel("Conta:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 14));

		JComboBox<String> cbbTipoConta = new JComboBox<String>();
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.BOLD, 14));

		txtTitular = new JTextField();
		txtTitular.setColumns(10);

		JButton btnConfirme = new JButton("Confirmar");
		btnConfirme.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setFont(new Font("Arial", Font.BOLD, 14));


		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnConfirme)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lbTipoConta)
									.addComponent(cbbTipoConta, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblTitular)
									.addComponent(txtTitular, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(91, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbAgncia)
								.addComponent(txtAgencia, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbConta)
								.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
							.addGap(107))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbAgncia)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbConta)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbTipoConta)
					.addGap(3)
					.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTitular)
					.addGap(2)
					.addComponent(txtTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnConfirme)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
