package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.OperacoesFacade;
import br.agencia.model.util.JNumberFormatField;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.model.util.ValidacoesException;
import br.agencia.view.principal.TelaBackground;

public class PagamentoCliente extends JPanel {

	private static final long serialVersionUID = -3894477076695872825L;
	private JNumberFormatField tfValor = null;
	private JTextField tfCodigoDeBarra;

	public PagamentoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbCdigoDeBarras = new JLabel("C\u00F3digo de Barras:");
		lbCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 18));

		tfCodigoDeBarra = new JTextField();
		tfCodigoDeBarra.setFont(new Font("Arial", Font.PLAIN, 17));
		tfCodigoDeBarra.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		tfCodigoDeBarra.setColumns(10);

		tfValor = new JNumberFormatField(new DecimalFormat("R$ ###,###,##0.00")).setLimit(11);
		tfValor.setFont(new Font("Arial", Font.PLAIN, 17));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfCodigoDeBarra.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Codigo de barras deve ser informado!");
					return;
				}

				OperacoesFacade contaPagar = new OperacoesFacade();
				try {
					contaPagar.pagar(UsuarioLogado.getContaUsuarioLogado().getAgencia().getNumAgencia(),
							UsuarioLogado.getContaUsuarioLogado().getNumero(), tfValor.getValue().multiply(new BigDecimal(-1)));
				} catch (ValidacoesException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
					return;
				}

				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new ConfirmaOperacao(tfValor.getValue(), TipoMovimento.PAGAMENTO));
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
