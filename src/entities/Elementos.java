package entities;

public class Elementos {
	private int elementos[];
	private int indice;
	private int tamanho;

	public void Fila(int tam)
	{
		tamanho = tam;
		elementos = new int[tamanho];
		indice = 0;
	}

	public void adicionar(int num) {
		if (indice < tamanho)
			elementos[indice++] = num;
	}

	public void remover() {
		for (int i = 1; i <= indice; i++)
			elementos[i - 1] = elementos[i];
	}

	public int obter(int ind) {
		return elementos[ind];
	}

	public void limpar() {
		indice = 0;
	}

	public int size() {
		return indice + 1;
	}
}
