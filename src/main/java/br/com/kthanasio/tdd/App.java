package br.com.kthanasio.tdd;

class App {
	
	public static void main(String[] args) {
		Pilha p = new Pilha(2);
		p.empilhar("First");
		System.out.println("Tamanho: " + p.tamanho());
		System.out.println("Topo: " + p.topo());
		
		p.empilhar("Second");
		System.out.println("Tamanho: " + p.tamanho());
		System.out.println("Topo: " + p.topo());
	}
}