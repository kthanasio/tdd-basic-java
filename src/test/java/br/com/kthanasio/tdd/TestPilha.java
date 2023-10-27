package br.com.kthanasio.tdd;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPilha {
	
	private Pilha p;
	
	@BeforeEach
	public void inicializaPilha() {
		p = new Pilha(10);
	}
	

	@Test
	public void pilhaVazia() {
		assertTrue(p.estaVazia());
		assertEquals(0, p.tamanho());
	}
	
	@Test
	public void empilhaElemento() {
		p.empilhar("Primeiro");
		assertFalse(p.estaVazia());
		assertEquals(1, p.tamanho());
		assertEquals("Primeiro", p.topo());
	}
	
	@Test
	public void empilhaEDesempinha() {
		p.empilhar("Primeiro");
		assertFalse(p.estaVazia());
		assertEquals(1, p.tamanho());
		assertEquals("Primeiro", p.topo());
		
		p.empilhar("Segundo");
		assertEquals(2, p.tamanho());
		assertEquals("Segundo", p.topo());
		
		Object desempilha = p.desempilha();
		assertEquals(1, p.tamanho());
		assertEquals("Primeiro", p.topo());
		assertEquals("Segundo", desempilha);
	}
	
	@Test
	public void desempilhaPilhaVazia() {
		
		PilhaVaziaException thrown = Assertions.assertThrows(PilhaVaziaException.class, () -> {
	           p.desempilha();
		});

		Assertions.assertEquals("Não é possível desempilhar.", thrown.getMessage());
		
	}
	
	@Test
	public void empilhaPilhaCheia() {
		for (int i = 0; i < 10; i++) {
			p.empilhar("elemento"+i);
		}
		
		PilhaCheiaException thrown = Assertions.assertThrows(PilhaCheiaException.class, () -> {
			p.empilhar("boom");
		});
		
		Assertions.assertEquals("Não é possível empilhar.", thrown.getMessage());
		
	}

}
