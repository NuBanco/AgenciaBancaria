package br.agencia.view.bancario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.agencia.control.GenericDao;
import br.agencia.model.Usuario;
import br.agencia.view.principal.TelaBackground;

public class ListaProfissional extends JPanel {

	private static final long serialVersionUID = -4635580930027968770L;
	private JTable tbProfissionais;

	public ListaProfissional() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		tbProfissionais = new JTable();
		tbProfissionais.setFont(new Font("Arial", Font.PLAIN, 13));
		tbProfissionais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		List<Usuario> profissionais = (List<Usuario>) GenericDao.listar("from Usuario where usu_tipousuario = 0");

		String coluna[] = { "Nome", "Username" };
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);

		profissionais.forEach(profissional -> modelo
				.addRow(new String[] { profissional.getPessoa().getNome(), profissional.getLogin() }));

		tbProfissionais.setModel(modelo);
		tbProfissionais.getColumnModel().getColumn(0).setResizable(false);

		JButton btnAdicionar = new JButton("+");
		btnAdicionar.setFont(new Font("Arial Black", Font.BOLD, 10));

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuBancario());
			}

		});

		scrollPane.setViewportView(tbProfissionais);

		// GroupLayout groupLayout = new GroupLayout(this);
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(Alignment.TRAILING,
														groupLayout.createSequentialGroup().addComponent(btnVoltar)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 92,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE,
																		42, GroupLayout.PREFERRED_SIZE)
																.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		TelaBackground.getPanelMenu().setLayout(groupLayout);
		// setLayout(groupLayout);
	}
}
