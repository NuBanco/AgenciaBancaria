package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import br.agencia.view.principal.AbstractTelaBackground;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class HomeMenuBancario extends AbstractTelaBackground {
	/**
	 *
	 */
	private static final long serialVersionUID = 5853409558338193456L;
	protected JPanel painelPrincipal = null;

	public HomeMenuBancario() {

		painelPrincipal = new JPanel();

		JPanel panel = new JPanel();

		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));

		JButton btnOpInformacoesConta = new JButton("1 - Informacoes");
		panel.add(btnOpInformacoesConta);

		btnOpInformacoesConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformacoesConta infConta = new InformacoesConta();
				infConta.setSize(319, 290);
				infConta.setLocationRelativeTo(null);
				infConta.setVisible(true);

			}

		});
		btnOpInformacoesConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpBalanco = new JButton("5 - Balan\u00E7o");
		panel.add(btnOpBalanco);
		btnOpBalanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balanco balanco = new Balanco();
				balanco.setSize(580, 470);
				balanco.setLocationRelativeTo(null);
				balanco.setVisible(true);
			}
		});
		btnOpBalanco.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpProfissionais = new JButton("4 - Profissionais");
		panel.add(btnOpProfissionais);
		btnOpProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProfissional profissionais = new ListaProfissional();
				profissionais.setSize(580, 470);
				profissionais.setLocationRelativeTo(null);
				profissionais.setVisible(true);
			}
		});
		btnOpProfissionais.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpNovaConta = new JButton("2 - Nova Conta");
		panel.add(btnOpNovaConta);
		btnOpNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaConta novaConta = new NovaConta();
				novaConta.setSize(580, 470);
				novaConta.setLocationRelativeTo(null);
				novaConta.setVisible(true);

			}
		});
		btnOpNovaConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpAgencias = new JButton("6 - Ag\u00EAncias");
		panel.add(btnOpAgencias);
		btnOpAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaAgencia agencias = new ListaAgencia();
				agencias.setSize(580, 470);
				agencias.setLocationRelativeTo(null);
				agencias.setVisible(true);
			}
		});
		btnOpAgencias.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpClientes = new JButton("3 - Clientes");
		panel.add(btnOpClientes);
		btnOpClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CCCCCCC");
			}
		});
		btnOpClientes.setFont(new Font("Arial", Font.BOLD, 17));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 470, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 292, Short.MAX_VALUE));
		groupLayout.setHonorsVisibility(false);

		// panel.setLayout(groupLayout);

		// panel.add(btnOpInformacoesConta);
		// panel.add(btnOpNovaConta);
		// panel.add(btnOpClientes);
		// panel.add(btnOpAgencias);
		// panel.add(btnOpBalanco);
		// panel.add(btnOpProfissionais);

		// panel.setSize(370, 260);

		// getPanelMenu().add(panel);
	}

	@Override
	public JPanel getPanelMenu() {
		return painelPrincipal;
	}

}
