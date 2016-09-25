package br.agencia.view.cliente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

public class SenhaCliente extends JFrame {

	private static final long serialVersionUID = 3187868024721495012L;
	private JPasswordField tfSenha;

	public SenhaCliente() {

		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		tfSenha.setEditable(false);

		JLabel lbDigiteSuaSenha = new JLabel("Digite sua senha utilizando o teclado virtual");
		lbDigiteSuaSenha.setFont(new Font("Arial", Font.BOLD, 18));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 20));

		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Arial", Font.BOLD, 15));

		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Arial", Font.BOLD, 15));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbDigiteSuaSenha)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnConfirmar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(tfSenha, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														165, GroupLayout.PREFERRED_SIZE))
										.addGap(18).addComponent(panel, GroupLayout.PREFERRED_SIZE, 248,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(19, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(21).addComponent(lbDigiteSuaSenha).addGap(18)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11).addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(102, Short.MAX_VALUE)));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_panel.createSequentialGroup()
												.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btn3,
														GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE))
								.addGroup(
										gl_panel.createSequentialGroup()
												.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addGap(6).addComponent(btn8, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGap(81)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(31, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
