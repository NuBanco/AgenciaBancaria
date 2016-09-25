package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.enums.TipoConta;
import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.JNumberFormatField;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.view.principal.TelaBackground;

public class DepositoCliente extends JPanel {

	private static final long serialVersionUID = 242114627222497452L;
	private JNumberFormatField tfValor = null;
	private JTextField tfAgencia;
	private JTextField tfConta;
	private JTextField tfTitular;

	private Agencia agenciaDeposito;
	private Conta contaDeposito;
	private JTextField tfTipoConta;

	public DepositoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JCheckBox chkContaLogada = new JCheckBox("Conta logada");
		chkContaLogada.setFont(new Font("Arial", Font.BOLD, 16));
		chkContaLogada.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (chkContaLogada.isSelected()) {
					contaDeposito = UsuarioLogado.getContaUsuarioLogado();
					tfAgencia.setText(contaDeposito.getAgencia().getCodAgencia());
					tfConta.setText(contaDeposito.getNumero());
					tfTitular.setText(contaDeposito.getPessoa().getNome());
					tfTipoConta.setText(contaDeposito.getTipoConta().name());

					tfAgencia.enable(false);
					tfConta.enable(false);
					tfTitular.enable(false);
					tfTipoConta.enable(false);

				} else {
					tfAgencia.setText("");
					tfConta.setText("");
					tfTitular.setText("");
					tfTipoConta.setText("");

					tfAgencia.enable(true);
					tfConta.enable(true);

				}
			}
		});
		chkContaLogada.setSelected(false);

		JLabel lbValorDeposito = new JLabel("Informe o valor a ser depositado:");
		lbValorDeposito.setFont(new Font("Arial", Font.BOLD, 16));
		tfValor = new JNumberFormatField(new DecimalFormat("R$ ###,###,##0.00")).setLimit(11);
		tfValor.setFont(new Font("Arial", Font.PLAIN, 16));
		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lbAg = new JLabel("Ag\u00EAncia:");
		lbAg.setFont(new Font("Arial", Font.BOLD, 16));

		tfAgencia = new JTextField();
		tfAgencia.setFont(new Font("Arial", Font.PLAIN, 16));
		tfAgencia.setColumns(10);

		tfConta = new JTextField();
		tfConta.setFont(new Font("Arial", Font.PLAIN, 16));
		tfConta.setColumns(10);

		JLabel lbConta = new JLabel("Conta:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbTitular = new JLabel("Titular:");
		lbTitular.setFont(new Font("Arial", Font.BOLD, 16));

		tfTitular = new JTextField();
		tfTitular.setFont(new Font("Arial", Font.PLAIN, 16));
		tfTitular.setColumns(10);
		tfTitular.enable(false);

		JButton btnConfirmar = new JButton("Confirme");
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfValor.getValue().doubleValue() <= 0) {
					JOptionPane.showMessageDialog(null, "Valor invalido para transferencia!");
					return;
				}

				agenciaDeposito = (Agencia) GenericDao.getGenericDao().consultarByQuery(
						String.format("from Agencia where age_numAgencia like '%s'", tfAgencia.getText()));
				if (agenciaDeposito == null) {
					JOptionPane.showMessageDialog(null, "Agencia nao encontrada!");
					return;
				}

				contaDeposito = (Conta) GenericDao.getGenericDao()
						.consultarByQuery(String.format("from Conta where con_numero like '%s' and con_idagencia = %d",
								tfConta.getText().trim(), agenciaDeposito.getId()));

				if (contaDeposito == null) {
					JOptionPane.showMessageDialog(null, "Conta nao encontrada!");
					return;
				}

				tfTitular.setText(contaDeposito.getPessoa().getNome());
				tfTipoConta.setText(contaDeposito.getTipoConta().name());

				contaDeposito.setSaldo(tfValor.getValue(), TipoMovimento.DEPOSITO);

				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new ConfirmaOperacao(tfValor.getValue(), TipoMovimento.DEPOSITO));
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));

		tfTipoConta = new JTextField();
		tfTipoConta.setFont(new Font("Arial", Font.PLAIN, 16));
		tfTipoConta.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		// GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(115).addGroup(groupLayout.createParallelGroup(
						Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lbTipoConta)
								.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(chkContaLogada)
										.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(tfTitular, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
										.addComponent(tfTipoConta, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING,
												groupLayout.createSequentialGroup().addComponent(btnVoltar).addGap(18)
														.addComponent(btnConfirmar))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(tfAgencia, GroupLayout.DEFAULT_SIZE, 190,
																		Short.MAX_VALUE)
																.addGap(18))
														.addGroup(groupLayout.createSequentialGroup().addComponent(lbAg)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lbConta, GroupLayout.PREFERRED_SIZE, 73,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(tfConta, GroupLayout.DEFAULT_SIZE, 215,
																Short.MAX_VALUE)))
										.addGroup(Alignment.TRAILING,
												groupLayout.createSequentialGroup().addGap(4).addComponent(lbTitular)
														.addPreferredGap(ComponentPlacement.RELATED, 365,
																Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lbValorDeposito)
												.addGap(18)
												.addComponent(tfValor, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
										.addGap(162))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(38)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbValorDeposito))
						.addGap(40).addComponent(chkContaLogada).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lbConta)
								.addComponent(lbAg))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(28).addComponent(lbTipoConta).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tfTipoConta, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(33).addComponent(lbTitular).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnVoltar)
								.addComponent(btnConfirmar))
						.addContainerGap(47, Short.MAX_VALUE)));
		// setLayout(groupLayout);
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
