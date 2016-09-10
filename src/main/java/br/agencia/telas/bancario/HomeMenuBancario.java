package br.agencia.telas.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import br.agencia.telas.TelaBackground;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeMenuBancario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5853409558338193456L;

	public HomeMenuBancario() {
		// setBounds(100, 100, 480, 280);

		JButton btnOpInformacoesConta = new JButton("1 - Informacoes");
		btnOpInformacoesConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformacoesConta infConta = new InformacoesConta();
				infConta.setSize(319, 290);
				infConta.setLocationRelativeTo(null);
				infConta.setVisible(true);	
				
			}
			
		});
		btnOpInformacoesConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpNovaConta = new JButton("2 - Nova Conta");
		btnOpNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground novaConta = new TelaBackground(new NovaConta());
				novaConta.setSize(580, 470);
				novaConta.setLocationRelativeTo(null);
				novaConta.setVisible(true);
			}
		});
		btnOpNovaConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpClientes = new JButton("3 - Clientes");
		btnOpClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CCCCCCC");
			}
		});
		btnOpClientes.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpAgencias = new JButton("6 - Ag\u00EAncias");
		btnOpAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground agencias = new TelaBackground(new ListaAgencia());
				agencias.setSize(580, 470);
				agencias.setLocationRelativeTo(null);
				agencias.setVisible(true);
			}
		});
		btnOpAgencias.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpBalanco = new JButton("5 - Balan\u00E7o");
		btnOpBalanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground balanco = new TelaBackground(new Balanco());
				balanco.setSize(580, 470);
				balanco.setLocationRelativeTo(null);
				balanco.setVisible(true);
			}
		});
		btnOpBalanco.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpProfissionais = new JButton("4 - Profissionais");
		btnOpProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground profissionais = new TelaBackground(new ListaProfissional());
				profissionais.setSize(580, 470);
				profissionais.setLocationRelativeTo(null);
				profissionais.setVisible(true);
			}
		});
		btnOpProfissionais.setFont(new Font("Arial", Font.BOLD, 17));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHonorsVisibility(false);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(28)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnOpInformacoesConta, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
								.addComponent(btnOpNovaConta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnOpClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(124)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpAgencias, GroupLayout.PREFERRED_SIZE, 180,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpBalanco, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpProfissionais, GroupLayout.PREFERRED_SIZE, 180,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpProfissionais, GroupLayout.PREFERRED_SIZE,
										50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpInformacoesConta, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE))
						.addGap(59)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnOpBalanco, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOpNovaConta, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))
						.addGap(56)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnOpAgencias, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOpClientes, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// HomeMenuBancario menuBancario = new HomeMenuBancario();
	// menuBancario.setLocationRelativeTo(null);
	// menuBancario.setVisible(true);
	// }
	// });
	// }
}
