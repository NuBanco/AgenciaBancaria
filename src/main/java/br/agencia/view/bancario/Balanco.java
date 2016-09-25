package br.agencia.view.bancario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.agencia.view.principal.TelaBackground;

public class Balanco extends JPanel {

	private static final long serialVersionUID = -1100684363335673889L;
	private JTextField tfDataInicial;
	private JTextField tfDataFinal;
	private JTable tbBalanco;
	public static final String ID = "BALANCO";

	public Balanco() {

		TelaBackground.getPanelMenu().add(new JPanel(), SwingConstants.CENTER);

		JButton btnRegressaAno = new JButton("I<");
		btnRegressaAno.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnRegressaMes = new JButton("<<");
		btnRegressaMes.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnRegressaDia = new JButton("<");
		btnRegressaDia.setFont(new Font("Arial", Font.BOLD, 14));

		tfDataInicial = new JTextField();
		tfDataInicial.setFont(new Font("Arial", Font.PLAIN, 14));
		tfDataInicial.setEditable(false);
		tfDataInicial.setColumns(10);

		tfDataFinal = new JTextField();
		tfDataFinal.setFont(new Font("Arial", Font.PLAIN, 14));
		tfDataFinal.setEditable(false);
		tfDataFinal.setColumns(10);

		JButton btnAvancaDia = new JButton(">");
		btnAvancaDia.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnAvancaMes = new JButton(">>");
		btnAvancaMes.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnAvancaAno = new JButton(">I");
		btnAvancaAno.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnImprimir = new JButton("");
		btnImprimir.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lbSaldoPerodoCaixa = new JLabel("(=)Saldo em Caixa R$");
		lbSaldoPerodoCaixa.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbValorSaldo = new JLabel("0,00");
		lbValorSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaldo.setFont(new Font("Arial", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane();
		tbBalanco = new JTable();

		JLabel lbValorDepositos = new JLabel("0,00");
		lbValorDepositos.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorDepositos.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbTotalDepositos = new JLabel("(+) Total Dep\u00F3sitos R$");
		lbTotalDepositos.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbValorSaques = new JLabel("0,00");
		lbValorSaques.setHorizontalAlignment(SwingConstants.RIGHT);
		lbValorSaques.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbTotalSaques = new JLabel("(-)Total Saques R$");
		lbTotalSaques.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuBancario());
			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(20).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnRegressaAno, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(2)
														.addComponent(btnRegressaMes, GroupLayout.PREFERRED_SIZE, 50,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnRegressaDia, GroupLayout.PREFERRED_SIZE, 50,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(
																tfDataInicial,
																GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
														.addGap(17))
												.addGroup(groupLayout.createSequentialGroup().addGap(174)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lbValorSaques, GroupLayout.PREFERRED_SIZE,
																		85, GroupLayout.PREFERRED_SIZE)
																.addComponent(lbValorDepositos,
																		GroupLayout.PREFERRED_SIZE, 85,
																		GroupLayout.PREFERRED_SIZE)))))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lbTotalSaques).addComponent(lbTotalDepositos)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(
												tfDataFinal, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addGap(18)
												.addComponent(lbSaldoPerodoCaixa)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnAvancaDia, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnAvancaMes, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAvancaAno,
														GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnImprimir)
												.addGap(4).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnVoltar)))))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(tbBalanco,
								GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)))
						.addGap(24)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup().addGap(20).addComponent(tbBalanco, GroupLayout.PREFERRED_SIZE, 259,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
										.addComponent(btnRegressaAno, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
										.addComponent(btnRegressaMes, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
										.addComponent(btnRegressaDia, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
										.addComponent(tfDataInicial, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbTotalDepositos, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbValorDepositos, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbSaldoPerodoCaixa, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbTotalSaques, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbValorSaques, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
												.addComponent(tfDataFinal, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnAvancaAno, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnAvancaMes, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnAvancaDia, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE))
										.addGap(28)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lbValorSaldo, GroupLayout.PREFERRED_SIZE, 15,
																GroupLayout.PREFERRED_SIZE)
														.addGap(27).addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE,
																28, GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap()));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}
}
