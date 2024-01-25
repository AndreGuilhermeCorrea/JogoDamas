package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entities.Jogador;

public class Cadastro extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static Jogador jogador[] = new Jogador[2];

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();

	JButton btSalvar = new JButton("Salvar");
	JLabel lbNomeJogador1 = new JLabel("Nome do jogador um:");
	JLabel lbNomeJogador2 = new JLabel("Nome do jogador dois:");

	JTextField tfNomeJogador1 = new JTextField(20);
	JTextField tfNomeJogador2 = new JTextField(20);

	public Cadastro() {
		p1.setLayout(new GridLayout(4, 1));
		p1.setBorder(new TitledBorder("Cadastro"));
		p1.add(lbNomeJogador1);
		p1.add(tfNomeJogador1);
		p1.add(lbNomeJogador2);
		p1.add(tfNomeJogador2);

		tfNomeJogador1.setText(jogador[0].getNome());
		tfNomeJogador2.setText(jogador[1].getNome());

		p2.setLayout(new BorderLayout());
		p2.add(p1, BorderLayout.CENTER);
		p2.add(btSalvar, BorderLayout.SOUTH);

		add(p2);
		btSalvar.addActionListener(this);

		setUndecorated(true);
		setModal(true);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setTitle("Cadastro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSalvar) {
			jogador[0].setNome(tfNomeJogador1.getText());
			jogador[1].setNome(tfNomeJogador2.getText());
			if (jogador[0].getNome().length() == 0)
				jogador[0].setNome("Branco");
			if (jogador[1].getNome().length() == 0)
				jogador[1].setNome("Preto");
			dispose();
		}
	}
}
