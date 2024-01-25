package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import entities.Jogador;
import gui.Cadastro;
import gui.Ranking;
import gui.Tabuleiro;

public class Inicio extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("/pictures/fundo.png")));
	ImageIcon iconeTitulo = new ImageIcon(Inicio.class.getResource("/pictures/icon.png"));
	JButton btUmJogador = new JButton("Um jogador");
	JButton btDoisJogadores = new JButton("Dois jogadores");
	
	JMenuBar menuBar = new JMenuBar();
	JMenu mnOpcoes = new JMenu("Opções");
	JMenuItem mitmCadastro = new JMenuItem("Cadastro");
	JMenuItem mitmRanking = new JMenuItem("Ranking");

	public Inicio() {
		Cadastro.jogador[0] = new Jogador("Branco");
		Cadastro.jogador[1] = new Jogador("Preto");
		setLayout(new BorderLayout());
		add(fundo);
		fundo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));
		fundo.add(p1);

		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		p1.add(btUmJogador);
		p1.add(btDoisJogadores);
		p1.setOpaque(false);

		btUmJogador.setFocusPainted(false);
		btUmJogador.addActionListener(this);
		btUmJogador.setBackground(Color.DARK_GRAY);
		btUmJogador.setForeground(Color.WHITE);

		btDoisJogadores.setFocusPainted(false);
		btDoisJogadores.addActionListener(this);
		btDoisJogadores.setBackground(Color.DARK_GRAY);
		btDoisJogadores.setForeground(Color.WHITE);
	
		mnOpcoes.setFont(new Font("Arial", Font.BOLD, 11));
		mitmCadastro.setFont(new Font("Arial", Font.BOLD, 11));
		mitmRanking.setFont(new Font("Arial", Font.BOLD, 11));
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnOpcoes);

		mitmCadastro.addActionListener(this);
		mnOpcoes.add(mitmCadastro);

		mitmRanking.addActionListener(this);
		mnOpcoes.add(mitmRanking);

		setIconImage(iconeTitulo.getImage());
		setVisible(true);
		setSize(490, 399);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Damas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btUmJogador) {
			dispose();
			new Tabuleiro();
		} else if (e.getSource() == btDoisJogadores) {
			dispose();
			new Tabuleiro(0);
		} else if (e.getSource() == mitmCadastro) {
			new Cadastro();
		} else if (e.getSource() == mitmRanking) {
			new Ranking();
		}
	}
}