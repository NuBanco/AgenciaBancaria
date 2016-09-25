package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.agencia.view.bancario.agencia.ListaAgencia;
import br.agencia.view.bancario.conta.CadastroConta;
import br.agencia.view.bancario.conta.ListaClientes;
import br.agencia.view.bancario.profissional.ListaProfissional;
import br.agencia.view.principal.TelaBackground;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HomeMenuBancario extends JPanel {

	private static final long serialVersionUID = 5853409558338193456L;

	public HomeMenuBancario() {

		JButton btnOpInformacoesConta = new JButton("1 - Informacoes");
		btnOpInformacoesConta.setBounds(83, 62, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpInformacoesConta);

		btnOpInformacoesConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformacoesConta popUp = new InformacoesConta();
				popUp.setSize(400, 300);
				popUp.setLocationRelativeTo(null);
				popUp.setVisible(true);
			}
		});
		btnOpInformacoesConta.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpBalanco = new JButton("5 - Balan\u00E7o");
		btnOpBalanco.setBounds(293, 62, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpBalanco);
		btnOpBalanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new Balanco());
			}
		});
		btnOpBalanco.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpProfissionais = new JButton("4 - Profissionais");
		btnOpProfissionais.setBounds(83, 116, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpProfissionais);
		btnOpProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new ListaProfissional());
			}
		});
		btnOpProfissionais.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpNovaConta = new JButton("2 - Nova Conta");
		btnOpNovaConta.setBounds(293, 116, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpNovaConta);
		btnOpNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new CadastroConta());
			}
		});
		btnOpNovaConta.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpAgencias = new JButton("6 - Ag\u00EAncias");
		btnOpAgencias.setBounds(83, 176, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpAgencias);
		btnOpAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new ListaAgencia());
			}
		});
		btnOpAgencias.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpClientes = new JButton("3 - Clientes");
		btnOpClientes.setBounds(293, 176, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpClientes);
		btnOpClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new ListaClientes());
			}
		});
		btnOpClientes.setFont(new Font("Arial", Font.BOLD, 23));

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(82)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpNovaConta, GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE)
								.addComponent(btnOpClientes, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(btnOpInformacoesConta, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
						.addGap(68)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnOpBalanco, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(btnOpProfissionais, GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
								.addComponent(btnOpAgencias, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
						.addGap(90)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(98)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOpProfissionais, GroupLayout.PREFERRED_SIZE,
										50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpInformacoesConta, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE))
						.addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOpNovaConta, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
								.addComponent(btnOpBalanco, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
						.addGap(41)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnOpClientes, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOpAgencias, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))
						.addGap(111)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
		TelaBackground.getPanelMenu().setVisible(true);
	}

	private void createPanel(final JPanel panel) {
		panel.setSize(700, 450);
		panel.setVisible(true);
	}

}
