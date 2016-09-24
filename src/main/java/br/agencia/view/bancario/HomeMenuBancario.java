package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
				InformacoesConta popUp = new InformacoesConta();
				popUp.setSize(400, 300);
				popUp.setLocationRelativeTo(null);
				popUp.setVisible(true);
			}
		});
		btnOpInformacoesConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpBalanco = new JButton("5 - Balan\u00E7o");
		btnOpBalanco.setBounds(293, 62, 180, 30);
		panel.add(btnOpBalanco);
		btnOpBalanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new Balanco());
			}
		});
		btnOpBalanco.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpProfissionais = new JButton("4 - Profissionais");
		btnOpProfissionais.setBounds(83, 116, 180, 30);
		panel.add(btnOpProfissionais);
		btnOpProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new ListaProfissional());
			}
		});
		btnOpProfissionais.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpNovaConta = new JButton("2 - Nova Conta");
		btnOpNovaConta.setBounds(293, 116, 180, 30);
		panel.add(btnOpNovaConta);
		btnOpNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new NovaConta());
			}
		});
		btnOpNovaConta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpAgencias = new JButton("6 - Ag\u00EAncias");
		btnOpAgencias.setBounds(83, 176, 180, 30);
		panel.add(btnOpAgencias);
		btnOpAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new ListaAgencia());
			}
		});
		btnOpAgencias.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpClientes = new JButton("3 - Clientes");
		btnOpClientes.setBounds(293, 176, 180, 30);
		panel.add(btnOpClientes);
		btnOpClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new ListaClientes());
			}
		});
		btnOpClientes.setFont(new Font("Arial", Font.BOLD, 17));

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 570, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 370, Short.MAX_VALUE));
		groupLayout.setHonorsVisibility(false);

		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

	private void createPanel(final JPanel panel) {
		panel.setSize(580, 470);
		panel.setVisible(true);
	}

}
