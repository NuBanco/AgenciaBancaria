package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.agencia.view.principal.TelaBackground;

public class PagamentoCliente extends JPanel {

	private static final long serialVersionUID = -3894477076695872825L;
	private JTextField txtCodigoBarras;
	private JFormattedTextField txtValor;

	public PagamentoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.PLAIN, 14));

		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodigoBarras.setColumns(10);

		txtValor = new JFormattedTextField();
		txtValor.setText("0.00");
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caractererNumerico = "0987654321.";
				if (!caractererNumerico.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblValor = new JLabel("Valor a ser pago");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblValor).addGroup(
						groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtValor, Alignment.LEADING)
										.addComponent(txtCodigoBarras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150,
												Short.MAX_VALUE)
										.addComponent(lblCdigoDeBarras, Alignment.LEADING))
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnConfirmar)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVoltar)))
				.addContainerGap(79, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(23).addComponent(lblCdigoDeBarras)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtCodigoBarras, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblValor).addGap(2)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 21,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnConfirmar).addComponent(btnVoltar))
										.addContainerGap(180, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
