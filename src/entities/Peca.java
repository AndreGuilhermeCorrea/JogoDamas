package entities;
import javax.swing.ImageIcon;

public class Peca {
	private int posI;
	private int posJ;
	private int tipo;
	private boolean dama = false;
	private boolean emJogo = true;
	private boolean jogavel = false;
	private boolean comer = false;
	private boolean comido = false;
	private ImageIcon img;

	public Peca(int cor, int i, int j) {
		tipo = cor;
		posI = i;
		posJ = j;
		if (tipo == 1)
			img = new ImageIcon(getClass().getResource("/pictures/branca.png"));
		else
			img = new ImageIcon(getClass().getResource("/pictures/preta.png"));
	}

	public void setJogavel(boolean res) {
		jogavel = res;
	}

	public boolean jogavel() {
		return jogavel;
	}

	public void setComer(boolean res) {
		comer = res;
	}

	public boolean comer() {
		return comer;
	}

	public void setComido(boolean res) {
		comido = res;
	}

	public boolean comido() {
		return comido;
	}

	public void tornarDama() {
		dama = true;
		if (tipo == 1)
			img = new ImageIcon(getClass().getResource("/pictures/branca-dama.png"));
		else
			img = new ImageIcon(getClass().getResource("/pictures/preta-dama.png"));
	}

	public boolean dama() {
		return dama;
	}

	public boolean emJogo() {
		return emJogo;
	}

	public void setEmJogo(boolean res) {
		emJogo = res;
	}

	public ImageIcon getPeca() {
		return img;
	}

	public int getPosI() {
		return posI;
	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosI(int i) {
		posI = i;
	}

	public void setPosJ(int j) {
		posJ = j;
	}

	public int getTipo() {
		return tipo;
	}
}
