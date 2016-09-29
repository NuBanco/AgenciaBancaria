package br.agencia.view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.OperacoesFacade;
import br.agencia.model.util.SenhaInvalidaException;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.view.principal.TelaBackground;

public class SenhaCliente extends JFrame {
	private static final long serialVersionUID = 3187868024721495012L;
	private JPasswordField tfSenha;
	private Conta contaUsuario;

	public SenhaCliente(BigDecimal valor, TipoMovimento tipo) {

		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		tfSenha.setEditable(false);

		JLabel lbDigiteSuaSenha = new JLabel("Digite sua senha utilizando o teclado virtual");
		lbDigiteSuaSenha.setFont(new Font("Arial", Font.BOLD, 18));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 20));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfSenha.getText().length() != 6) {
					JOptionPane.showMessageDialog(null, "A senha de operacoes do usuario deve possuir 6 digitos!");
					limpaCampoSenha();
					return;
				}

				try {
					OperacoesFacade operacao = new OperacoesFacade();
					operacao.validarSenha(UsuarioLogado.getContaUsuarioLogado(), tfSenha.getText(), valor, tipo);
				} catch (SenhaInvalidaException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
					return;
				}

				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu()
						.add(new ConfirmaOperacao(valor, tipo));
				dispose();
			}
		});

		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.BOLD, 13));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(0);
			}
		});

		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Arial", Font.BOLD, 13));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(1);
			}
		});

		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Arial", Font.BOLD, 13));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(2);
			}
		});

		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Arial", Font.BOLD, 13));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(3);
			}
		});

		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Arial", Font.BOLD, 13));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(4);
			}
		});

		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Arial", Font.BOLD, 13));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(5);
			}
		});

		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Arial", Font.BOLD, 13));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(6);
			}
		});

		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Arial", Font.BOLD, 13));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(7);
			}
		});

		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Arial", Font.BOLD, 13));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(8);
			}
		});

		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Arial", Font.BOLD, 13));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirSenhaOperacao(9);
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 18));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampoSenha();
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lbDigiteSuaSenha)
								.addGroup(groupLayout
										.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnConfirmar, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(tfSenha, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 165,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 165,
														GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 301, Short.MAX_VALUE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(21).addComponent(lbDigiteSuaSenha).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLimpar,
												GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));

		GroupLayout panel_numeros = new GroupLayout(panel);
		panel_numeros.setHorizontalGroup(panel_numeros.createParallelGroup(Alignment.LEADING).addGroup(panel_numeros
				.createSequentialGroup().addContainerGap()
				.addGroup(
						panel_numeros.createParallelGroup(Alignment.LEADING)
								.addGroup(
										panel_numeros.createSequentialGroup()
												.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btn3,
														GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE))
								.addGroup(
										panel_numeros.createSequentialGroup()
												.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addGap(6).addComponent(btn8, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(panel_numeros.createParallelGroup(Alignment.LEADING)
						.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGap(81)));
		panel_numeros.setVerticalGroup(panel_numeros.createParallelGroup(Alignment.LEADING)
				.addGroup(panel_numeros.createSequentialGroup().addContainerGap()
						.addGroup(panel_numeros.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(panel_numeros.createParallelGroup(Alignment.LEADING)
								.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(panel_numeros.createParallelGroup(Alignment.BASELINE)
										.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(panel_numeros.createParallelGroup(Alignment.BASELINE)
										.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(panel_numeros);
		getContentPane().setLayout(groupLayout);
	}

	private void inserirSenhaOperacao(Integer digito) {
		tfSenha.setText(tfSenha.getText().concat(digito.toString()));
	}

	public String getSenhaOperacao() {
		return tfSenha.getText();
	}

	private void limpaCampoSenha() {
		tfSenha.setText("");
	}

}
