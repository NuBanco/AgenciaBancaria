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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.JNumberFormatField;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.view.principal.TelaBackground;

public class TransferenciaCliente extends JPanel {

	private static final long serialVersionUID = 6069759280137589329L;
	private JTextField tfAgencia;
	private JTextField tfConta;
	private JTextField tfTitular;
	private JTextField tfTipoConta;
	private JNumberFormatField tfValor = null;

	private Agencia agenciaTransferencia;
	private Conta contaTransferencia;

	public TransferenciaCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbContaDestino = new JLabel("Conta de destino/Cr\u00E9dito");
		lbContaDestino.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel lbAgencia = new JLabel("Ag\u00EAncia:");
		lbAgencia.setFont(new Font("Arial", Font.BOLD, 16));

		tfAgencia = new JTextField();
		tfAgencia.setFont(new Font("Arial", Font.PLAIN, 16));
		tfAgencia.setColumns(10);

		JLabel TipoConta = new JLabel("Tipo Conta:");
		TipoConta.setFont(new Font("Arial", Font.BOLD, 16));

		tfTipoConta = new JTextField();
		tfTipoConta.setFont(new Font("Arial", Font.PLAIN, 16));
		tfTipoConta.enable(false);

		tfConta = new JTextField();
		tfConta.setFont(new Font("Arial", Font.PLAIN, 16));
		tfConta.setColumns(10);

		JLabel lbTitular = new JLabel("Titular:");
		lbTitular.setFont(new Font("Arial", Font.BOLD, 16));

		tfTitular = new JTextField();
		tfTitular.setFont(new Font("Arial", Font.PLAIN, 16));
		tfTitular.setColumns(10);
		tfTitular.enable(false);

		JNumberFormatField numberFormatField = new JNumberFormatField(new DecimalFormat("R$ ###,###,##0.00"));
		tfValor = numberFormatField.setLimit(11);
		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValor.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbValor = new JLabel("Valor:");
		lbValor.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfValor.getValue().doubleValue() <= 0) {
					JOptionPane.showMessageDialog(null, "Valor invalido para transferencia!");
					return;
				}

				if (tfValor.getValue().doubleValue() > UsuarioLogado.getContaUsuarioLogado().getSaldo().doubleValue()) {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente para operacao!");
					return;
				}

				agenciaTransferencia = (Agencia) GenericDao.getGenericDao().consultarByQuery(
						String.format("from Agencia where age_numAgencia like '%s'", tfAgencia.getText()));
				if (agenciaTransferencia == null) {
					JOptionPane.showMessageDialog(null, "Agencia nao encontrada!");
					return;
				}

				contaTransferencia = (Conta) GenericDao.getGenericDao()
						.consultarByQuery(String.format("from Conta where con_numero like '%s' and con_idagencia = %d",
								tfConta.getText().trim(), agenciaTransferencia.getId()));

				if (contaTransferencia == null) {
					JOptionPane.showMessageDialog(null, "Conta nao encontrada!");
					return;
				}

				tfTitular.setText(contaTransferencia.getPessoa().getNome());
				tfTipoConta.setText(contaTransferencia.getTipoConta().name());

				contaTransferencia.setSaldo(tfValor.getValue(), TipoMovimento.TRANSFERENCIA);
				UsuarioLogado.getContaUsuarioLogado().setSaldo(tfValor.getValue().multiply(new BigDecimal(-1)), TipoMovimento.TRANSFERENCIA);

				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new ConfirmaOperacao(tfValor.getValue(), TipoMovimento.DEPOSITO));

			}
		});
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lbConta = new JLabel("Conta:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		// GroupLayout groupLayout = new GroupLayout(this);
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup().addGap(
								114)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lbTitular, GroupLayout.PREFERRED_SIZE, 137,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbContaDestino, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 576,
												Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(
												groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(
														tfTitular, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, 458,
														Short.MAX_VALUE)
														.addGroup(groupLayout
																.createSequentialGroup().addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(tfTipoConta,
																						Alignment.LEADING, 0,
																						295, Short.MAX_VALUE)
																				.addComponent(tfAgencia,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE, 295,
																						Short.MAX_VALUE)
																				.addComponent(lbAgencia,
																						Alignment.LEADING,
																						GroupLayout.PREFERRED_SIZE, 90,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(TipoConta,
																						GroupLayout.PREFERRED_SIZE, 151,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)))
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(27)
																				.addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(lbConta)
																						.addComponent(tfConta)))
																		.addGroup(Alignment.LEADING,
																				groupLayout.createSequentialGroup()
																						.addGap(27).addGroup(groupLayout
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(lbValor)
																								.addComponent(tfValor,
																										GroupLayout.DEFAULT_SIZE,
																										115,
																										Short.MAX_VALUE)))))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(btnVoltar).addGap(18)
																.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE,
																		113, GroupLayout.PREFERRED_SIZE)))
												.addGap(118)))
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(32)
								.addComponent(lbContaDestino, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lbConta)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(tfConta, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lbAgencia)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfAgencia,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(28)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbValor)
										.addComponent(TipoConta))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE))
								.addGap(30).addComponent(lbTitular).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(43).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnConfirmar).addComponent(btnVoltar))
								.addContainerGap(91, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
		// setLayout(groupLayout);
	}
}
