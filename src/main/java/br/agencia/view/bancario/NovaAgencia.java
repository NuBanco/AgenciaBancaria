package br.agencia.view.bancario;

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

import br.agencia.control.GenericDao;
import br.agencia.model.Agencia;
import br.agencia.view.principal.TelaBackground;

public class NovaAgencia extends JPanel {

	private static final long serialVersionUID = -673412907306051111L;
	private JTextField txtNome;
	private JTextField txtNumero;
	private JTextField txtCidade;

	public NovaAgencia(Agencia agencia) {
		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validarNovaAgencia()) {
					agencia.setNome(txtNome.getText());
					agencia.setCodAgencia(txtNumero.getText());
					agencia.setCidade(txtCidade.getText());

					gravarAgencia(agencia);

					limparTela();
				}
			}
		});

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNome.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});

		txtNumero.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCidade.setColumns(10);

		if (agencia.getId() != null) {
			txtNome.setText(agencia.getNome());
			txtNumero.setText(agencia.getCodAgencia());
			txtCidade.setText(agencia.getCidade());
		}

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new ListaAgencia());
			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(48)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnVoltar).addGap(18).addComponent(btnConfirmar))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtCidade, Alignment.LEADING).addComponent(txtNumero, Alignment.LEADING)
								.addComponent(lblNome, Alignment.LEADING)
								.addComponent(txtNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 304,
										Short.MAX_VALUE)
								.addComponent(lblCidade, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumero, Alignment.LEADING)))
				.addContainerGap(98, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(22).addComponent(lblNome)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(13).addComponent(lblNumero).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblCidade)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(40)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnConfirmar).addComponent(btnVoltar))
										.addContainerGap(51, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);

	}

	protected void gravarAgencia(Agencia agencia) {
		if (agencia.getId() == null) {
			GenericDao.getGenericDao().incluir(agencia);
			JOptionPane.showMessageDialog(null,
					String.format("Agencia %s criada com sucesso!", txtNome.getText()));
		} else {
			GenericDao.getGenericDao().alterar(agencia);
			JOptionPane.showMessageDialog(null,
					String.format("Agencia %s alterada com sucesso!", txtNome.getText()));
		}
	}

	protected void limparTela() {
		txtNome.setText("");
		txtNumero.setText("");
		txtCidade.setText("");
	}

	protected boolean validarNovaAgencia() {
		if (txtNome.getText().length() == 0 || txtNumero.getText().length() == 0 || txtCidade.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
			return false;
		}

		Agencia agenciaValidar = (Agencia) GenericDao
				.consultarByString(String.format("from Agencia where age_numAgencia like '%s'", txtNumero.getText()));

		if (agenciaValidar != null) {
			JOptionPane.showMessageDialog(null, String.format("Agencia %s já cadstrada!", txtNumero.getText()));
			return false;
		}

		return true;
	}
}
