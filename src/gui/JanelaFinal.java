package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Jogador;
import game.Inicio;

public class JanelaFinal extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	//private final JPanel contentPanel = new JPanel();

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	JLabel fundo;
	JLabel lbVencedor = new JLabel("Vencedor: Bruno");
	JLabel lbTempo = new JLabel("Tempo: 01:26");

	JButton btReiniciar = new JButton("Reiniciar");
	JButton btMenu = new JButton("Voltar ao menu");
	JButton btSair = new JButton("Sair");

	Tabuleiro tabuleiro;

	Jogador vencedor;
	int tempo;

	public JanelaFinal(int modo, int vencedor) {
		if ((modo == 0 && vencedor == 0) || modo == 1)
			fundo = new JLabel(new ImageIcon(getClass().getResource("/pictures/vitoria.png")));
		else
			fundo = new JLabel(new ImageIcon(getClass().getResource("/pictures/derrota.png")));

		setLayout(new BorderLayout());
		add(fundo);
		fundo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		fundo.add(p1);

		p1.setLayout(new GridLayout(4, 1, 0, 10));
		p1.add(p2);
		p1.add(btReiniciar);
		p1.add(btMenu);
		p1.add(btSair);
		p1.setOpaque(false);

		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.setOpaque(false);
		p2.add(p3);
		p2.add(p4);

		p3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		p3.add(lbVencedor);
		p3.setOpaque(false);

		p4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		p4.add(lbTempo);
		p4.setOpaque(false);

		btReiniciar.setFocusPainted(false);
		btReiniciar.setBackground(Color.WHITE);
		btReiniciar.addActionListener(this);

		btMenu.setFocusPainted(false);
		btMenu.setBackground(Color.WHITE);
		btMenu.addActionListener(this);

		btSair.setFocusPainted(false);
		btSair.setBackground(Color.WHITE);
		btSair.addActionListener(this);

		lbVencedor.setForeground(Color.WHITE);
		lbVencedor.setFont(new Font("Arial", Font.BOLD, 15));

		lbTempo.setForeground(Color.WHITE);
		lbTempo.setFont(new Font("Arial", Font.BOLD, 15));

		setUndecorated(true);
		setModal(true);
		setResizable(false);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		// setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btReiniciar) {
			dispose();
			tabuleiro.iniciarJogo();
		} else if (e.getSource() == btMenu) {
			tabuleiro.dispose();
			dispose();
			new Inicio();
		} else if (e.getSource() == btSair) {
			System.exit(0);
		}
	}

	public void setTabuleiro(Tabuleiro tb) {
		tabuleiro = tb;
	}

	public void setVencedor(Jogador winner) {
		vencedor = winner;
		lbVencedor.setText("Vencedor: " + vencedor.getNome());
	}

	public void setTempo(int tmp) {
		tempo = tmp;
		lbTempo.setText(String.format("Tempo: %02d:%02d", tempo / 60, tempo % 60));
		for (int i = 0; i < 5; i++)
			if (tempo < Ranking.tempo[i] || Ranking.nomes[i].length() == 0) {
				for (int j = 4; j > i; j--) {
					Ranking.tempo[j] = Ranking.tempo[j - 1];
					Ranking.nomes[j] = Ranking.nomes[j - 1];
				}
				Ranking.tempo[i] = tempo;
				Ranking.nomes[i] = vencedor.getNome();
				break;
			}
	}

	public void mostrar() {
		setVisible(true);
	}

}
