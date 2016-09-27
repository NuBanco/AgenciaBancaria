package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.JNumberFormatField;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.view.principal.TelaBackground;

public class OpcoesSaque extends JPanel {

	private static final long serialVersionUID = 2914438307389368709L;
	private JNumberFormatField tfValor = null;

	public OpcoesSaque() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JButton btnOp50 = new JButton("R$ 50,00");
		btnOp50.setFont(new Font("Arial", Font.BOLD, 20));
		btnOp50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(50.00));
			}
		});

		JButton btnOp100 = new JButton("R$ 100,00");
		btnOp100.setFont(new Font("Arial", Font.BOLD, 20));
		btnOp100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(100.00));
			}
		});

		JButton btnOp200 = new JButton("R$ 200,00");
		btnOp200.setFont(new Font("Arial", Font.BOLD, 20));
		btnOp200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(200.00));
			}
		});

		JButton btnOp300 = new JButton("R$ 300,00");
		btnOp300.setFont(new Font("Arial", Font.BOLD, 20));
		btnOp300.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(300.00));
			}
		});

		JButton btnOp500 = new JButton("R$ 500,00");
		btnOp500.setFont(new Font("Arial", Font.BOLD, 20));
		btnOp500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(new BigDecimal(500.00));
			}
		});

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcaoSacar(tfValor.getValue());
			}
		});

		JLabel lbValorEspecifico = new JLabel("Informe outro valor:");
		lbValorEspecifico.setFont(new Font("Arial", Font.BOLD, 16));

		tfValor = new JNumberFormatField(new DecimalFormat("R$ ###,###,##0.00")).setLimit(11);
		tfValor.setFont(new Font("Arial", Font.PLAIN, 16));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOp100, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
						.addComponent(btnOp500, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
						.addComponent(btnOp50, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGap(94)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tfValor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING,
								groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnOp200, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 309,
												Short.MAX_VALUE)
										.addComponent(btnOp300, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
						.addComponent(lbValorEspecifico))
				.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(403, Short.MAX_VALUE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addGap(60)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(82)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnOp50, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOp200, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))
								.addGap(87))
						.addGroup(Alignment.TRAILING,
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnOp300, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOp100, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)))
				.addGap(31)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addComponent(lbValorEspecifico)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfValor,
												GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnOp500, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50,
								GroupLayout.PREFERRED_SIZE))
				.addGap(71)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(40, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

	private void OpcaoSacar(BigDecimal valor) {
		if (valor.doubleValue() <= 0) {
			JOptionPane.showMessageDialog(null, "Valor invalido para saque!");
			return;
		}

		if (valor.doubleValue() > UsuarioLogado.getContaUsuarioLogado().getSaldo().doubleValue()) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente para operacao!");
			return;
		}

		UsuarioLogado.getContaUsuarioLogado().setSaldo(valor.multiply(new BigDecimal(-1)), TipoMovimento.SAQUE);

		TelaBackground.clearPanelMenu();
		TelaBackground.getPanelMenu().add(new ConfirmaOperacao(valor, TipoMovimento.SAQUE));

	}
}
