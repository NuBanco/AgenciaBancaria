package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.JNumberFormatField;
import br.agencia.view.principal.TelaBackground;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ConfirmaOperacao extends JPanel {

	private static final long serialVersionUID = 3993718123138322069L;
	private JLabel tfValor = null;

	public ConfirmaOperacao(BigDecimal valor, TipoMovimento tipoMovimento) {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);
		DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0.00");

		JLabel lbOperacao = new JLabel(
				String.format("Opera\u00E7\u00E3o %s realizada com sucesso!", tipoMovimento.name()));
		lbOperacao.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbValor = new JLabel("Valor: R$ " + valor.toString());
		lbValor.setFont(new Font("Arial", Font.PLAIN, 17));

		tfValor = new JLabel(valor.toString());
		tfValor.setText(valor.toString());
		tfValor.setForeground(Color.BLACK);
		tfValor.setFont(new Font("Arial", Font.BOLD, 17));
		tfValor.setEnabled(false);

		JButton btnOpRetornar = new JButton("Retornar");
		btnOpRetornar.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Arial", Font.BOLD, 17));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JasperPrint rel = null;

				try {
					HashMap map = new HashMap();
					JasperPrint printReport = JasperFillManager.fillReport(
							"NuBanco//src//main//java//br//agencia//view//relatorios//RelatorioConfirmar.jasper", null,
							DriverManager.getConnection("jdbc:postgresql://localhost:5432/NuBanco", "postgres",
									"postgres"));
					JasperExportManager.exportReportToPdfFile(printReport, "relatorio/reportex.pdf");
				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, "Erro: " + x.getMessage());
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		//GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbOperacao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOpRetornar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lbValor, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(111)))
					.addGap(1058))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(340)
					.addComponent(btnImprimir)
					.addContainerGap(990, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(lbOperacao)
					.addGap(18)
					.addComponent(lbValor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOpRetornar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addComponent(btnImprimir)
					.addGap(26))
		);
		//setLayout(groupLayout);
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}
}
