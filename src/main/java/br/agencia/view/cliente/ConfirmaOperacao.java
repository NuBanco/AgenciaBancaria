package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.JNumberFormatField;
import br.agencia.view.principal.TelaBackground;
import javax.swing.UIManager;

public class ConfirmaOperacao extends JPanel {

	private static final long serialVersionUID = 3993718123138322069L;
	private JNumberFormatField textField = null;

	public ConfirmaOperacao(BigDecimal valor, TipoMovimento tipoMovimento) {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbOperacao = new JLabel(
				String.format("Opera\u00E7\u00E3o %s realizada com sucesso!", tipoMovimento.name()));
		lbOperacao.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbValor = new JLabel("Valor: R$ ");
		lbValor.setFont(new Font("Arial", Font.PLAIN, 17));

		textField = new JNumberFormatField(new DecimalFormat("###,###,##0.00"));
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Arial", Font.BOLD, 17));
		textField.setEnabled(false);
		textField.setBackground(UIManager.getColor("Button.light"));
		textField.setColumns(10);
		textField.setText(valor.toString());

		JButton btnOpRetornar = new JButton("Retornar");
		btnOpRetornar.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		JButton btnOpImprimir = new JButton("");

		// GroupLayout groupLayout = new GroupLayout(this);
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout
						.createSequentialGroup().addGap(33).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lbValor, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE,
												125, GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnOpRetornar, GroupLayout.PREFERRED_SIZE, 110,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lbOperacao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(81))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(410, Short.MAX_VALUE)
						.addComponent(btnOpImprimir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(55).addComponent(lbOperacao).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lbValor)
						.addComponent(btnOpRetornar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(146).addComponent(btnOpImprimir, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		// setLayout(groupLayout);
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}
}
