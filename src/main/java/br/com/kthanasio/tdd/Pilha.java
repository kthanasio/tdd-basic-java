package br.com.kthanasio.tdd;

public class Pilha {
	
	private Object[] elementos;
	private int tamanho = 0;

	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return (tamanho == 0);
	}

	public int tamanho() {
		return tamanho;
	}

	public void empilhar(Object elemento) {
		if (tamanho == elementos.length) 
			throw new PilhaCheiaException("Não é possível empilhar.");
		
		this.elementos[tamanho] = elemento;
		tamanho++;
	}

	public Object topo() {
		return elementos[tamanho-1];
	}

	public Object desempilha() {
		if (estaVazia())
			throw new PilhaVaziaException("Não é possível desempilhar.");
		Object topo = topo();
		tamanho--;
		return topo;
		
	}

}
