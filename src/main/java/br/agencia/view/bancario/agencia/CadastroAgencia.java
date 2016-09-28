package br.agencia.view.bancario.agencia;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.view.principal.TelaBackground;

public class CadastroAgencia extends JPanel {

	private static final long serialVersionUID = -673412907306051111L;
	private JTextField tfNome;
	private JTextField tfNumero;
	private JTextField tfCidade;

	public CadastroAgencia(Agencia agencia) {
		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarNovaAgencia(agencia)) {
					agencia.setNome(tfNome.getText());
					agencia.setNumAgencia(tfNumero.getText());
					agencia.setCidade(tfCidade.getText());

					gravarAgencia(agencia);
					TelaBackground.clearPanelMenu();
					TelaBackground.getPanelMenu().add(new ListaAgencia());
				}
			}
		});

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Arial", Font.BOLD, 16));

		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 16));
		tfNome.setColumns(10);

		JLabel lbNumero = new JLabel("N\u00FAmero:");
		lbNumero.setFont(new Font("Arial", Font.BOLD, 16));

		tfNumero = new JTextField();
		tfNumero.setFont(new Font("Arial", Font.PLAIN, 16));
		tfNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});

		tfNumero.setColumns(10);

		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Arial", Font.PLAIN, 16));
		tfCidade.setColumns(10);

		if (agencia.getId() != null) {
			tfNome.setText(agencia.getNome());
			tfNumero.setText(agencia.getNumAgencia());
			tfCidade.setText(agencia.getCidade());
		}

		JLabel lbCidade = new JLabel("Cidade:");
		lbCidade.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new ListaAgencia());
			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(108)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addComponent(btnVoltar).addGap(26)
												.addComponent(btnConfirmar))
								.addGroup(Alignment.TRAILING,
										groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lbNome, Alignment.LEADING)
												.addComponent(tfNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 497,
														Short.MAX_VALUE)
												.addComponent(tfNumero, Alignment.LEADING)
												.addComponent(lbNumero, Alignment.LEADING)
												.addComponent(tfCidade, Alignment.LEADING).addComponent(lbCidade,
														Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87,
														GroupLayout.PREFERRED_SIZE)))
						.addGap(95)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addGap(23).addComponent(lbNome)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(32).addComponent(lbNumero).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(lbCidade).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(119)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnConfirmar).addComponent(btnVoltar))
										.addContainerGap(67, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);

	}

	protected void gravarAgencia(Agencia agencia) {
		if (agencia.getId() == null) {
			ObjectDao.getObjectDao().incluir(agencia);
			JOptionPane.showMessageDialog(null, String.format("Agencia %s criada com sucesso!", tfNome.getText()));
		} else {
			ObjectDao.getObjectDao().alterar(agencia);
			JOptionPane.showMessageDialog(null, String.format("Agencia %s alterada com sucesso!", tfNome.getText()));
		}
	}

	protected void limparTela() {
		tfNome.setText("");
		tfNumero.setText("");
		tfCidade.setText("");
	}

	protected boolean validarNovaAgencia(Agencia agencia) {
		if (tfNome.getText().length() == 0 || tfNumero.getText().length() == 0 || tfCidade.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
			return false;
		}

		if (agencia.getId() == null) {
			Agencia agenciaValidar = (Agencia) ObjectDao
					.consultarByQuery(String.format("from Agencia where age_numAgencia like '%s'", tfNumero.getText()));

			if (agenciaValidar != null) {
				JOptionPane.showMessageDialog(null, String.format("Agencia %s já cadstrada!", tfNumero.getText()));
				return false;
			}
		}

		return true;
	}
}
