package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingConstants;

import br.agencia.view.principal.TelaBackground;

public class PagamentoCliente extends JPanel {

	private static final long serialVersionUID = -3894477076695872825L;
	private JTextField tfCodigoDeBarra;
	private JFormattedTextField tfValor;

	public PagamentoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbCdigoDeBarras = new JLabel("C\u00F3digo de Barras:");
		lbCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 18));

		tfCodigoDeBarra = new JTextField();
		tfCodigoDeBarra.setFont(new Font("Arial", Font.PLAIN, 17));
		tfCodigoDeBarra.setColumns(10);

		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValor.setFont(new Font("Arial", Font.PLAIN, 17));
		try {
			tfValor = new JFormattedTextField(new MaskFormatter("###.###.###,##"));
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar o parser do valor!");
		}

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lbValor = new JLabel("Valor a ser pago:");
		lbValor.setFont(new Font("Arial", Font.BOLD, 18));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnVoltar)
								.addGap(18).addComponent(btnConfirmar))
						.addGroup(groupLayout.createSequentialGroup().addGap(187)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lbValor)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(tfValor, Alignment.LEADING)
												.addComponent(lbCdigoDeBarras, Alignment.LEADING,
														GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfCodigoDeBarra, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))))
						.addGap(208)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(116).addComponent(lbCdigoDeBarras)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfCodigoDeBarra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lbValor).addGap(2)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(47).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConfirmar).addComponent(btnVoltar))
						.addContainerGap(113, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
