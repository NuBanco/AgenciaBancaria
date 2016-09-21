package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.agencia.view.principal.TelaBackground;

public class HomeMenuBancario extends JPanel {

	private static final long serialVersionUID = 5853409558338193456L;

	public HomeMenuBancario() {

		JPanel panel = new JPanel();

		panel = TelaBackground.getPanelMenu();
		panel.setLayout(null);
		panel.setVisible(true);

		JButton btnOpInformacoesConta = new JButton("1 - Informacoes");
		btnOpInformacoesConta.setBounds(83, 62, 180, 30);
		panel.add(btnOpInformacoesConta);

		btnOpInformacoesConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				InformacoesConta infConta = new InformacoesConta();
				infConta.setSize(500, 350);
				infConta.setVisible(true);

			}

		});
		btnOpInformacoesConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpBalanco = new JButton("5 - Balan\u00E7o");
		btnOpBalanco.setBounds(293, 62, 180, 30);
		panel.add(btnOpBalanco);
		btnOpBalanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				Balanco balanco = new Balanco();
				balanco.setSize(580, 470);
				balanco.setVisible(true);
			}
		});
		btnOpBalanco.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpProfissionais = new JButton("4 - Profissionais");
		btnOpProfissionais.setBounds(83, 116, 180, 30);
		panel.add(btnOpProfissionais);
		btnOpProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				ListaProfissional profissionais = new ListaProfissional();
				profissionais.setSize(580, 470);
				profissionais.setLocation(null);
				profissionais.setVisible(true);
			}
		});
		btnOpProfissionais.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpNovaConta = new JButton("2 - Nova Conta");
		btnOpNovaConta.setBounds(293, 116, 180, 30);
		panel.add(btnOpNovaConta);
		btnOpNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				NovaConta novaConta = new NovaConta();
				novaConta.setSize(580, 470);
				novaConta.setLocation(null);
				novaConta.setVisible(true);

			}
		});
		btnOpNovaConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpAgencias = new JButton("6 - Ag\u00EAncias");
		btnOpAgencias.setBounds(83, 176, 180, 30);
		panel.add(btnOpAgencias);
		btnOpAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				ListaAgencia agencias = new ListaAgencia();
				agencias.setSize(580, 470);
				agencias.setLocation(null);
				agencias.setVisible(true);
			}
		});
		btnOpAgencias.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpClientes = new JButton("3 - Clientes");
		btnOpClientes.setBounds(293, 176, 180, 30);
		panel.add(btnOpClientes);
		btnOpClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CCCCCCC");
			}
		});
		btnOpClientes.setFont(new Font("Arial", Font.BOLD, 17));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 570, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 370, Short.MAX_VALUE));
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

}
