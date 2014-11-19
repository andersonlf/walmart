/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.processador;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import br.com.walmart.entidades.Malha;
import br.com.walmart.entidades.Ponto;

/**
 * Classe de teste unitário do ProcessadorMalhaLogistica.
 *
 * @author andersonlf@gmail.com
 */
public class ProcessadorMalhaLogisticaTest {

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar() {
		StringBuilder sb = new StringBuilder();
		sb.append("A B 10\n");
		sb.append("B D 15\n");
		sb.append("A C 20\n");
		sb.append("C D 30\n");
		sb.append("B E 50\n");
		sb.append("D E 30");
		
		Malha malha = ProcessadorMalhaLogistica.processar("TesteMalha", sb.toString());
		
		assertEquals("TesteMalha", malha.getNome());
		assertEquals(5, malha.getPontos().size());
		
		testPontoA(malha);
		testPontoB(malha);
		testPontoC(malha);
		testPontoD(malha);
		testPontoE(malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar2() {
		Malha malha = ProcessadorMalhaLogistica.processar(null, null);
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar3() {
		Malha malha = ProcessadorMalhaLogistica.processar(null, "");
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar4() {
		Malha malha = ProcessadorMalhaLogistica.processar("", null);
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar5() {
		Malha malha = ProcessadorMalhaLogistica.processar("", "");
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar6() {
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", "");
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar7() {
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", "Malha inválida");
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar8() {
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", "AB10");
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar9() {
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", "A B10");
		assertEquals(null, malha);
	}
	
	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar10() {
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", " A B10");
		assertEquals(null, malha);
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar11() {
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", "A B 10");
		assertEquals("Nome válido", malha.getNome());
		assertEquals(2, malha.getPontos().size());
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar12() {
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", "A B 10 ");
		assertEquals("Nome válido", malha.getNome());
		assertEquals(2, malha.getPontos().size());
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar13() {
		StringBuilder sb = new StringBuilder();
		sb.append("A B 10 \n");
		
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", sb.toString());
		assertEquals("Nome válido", malha.getNome());
		assertEquals(2, malha.getPontos().size());
	}

	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testProcessar14() {
		StringBuilder sb = new StringBuilder();
		sb.append("A B 10 \n");
		sb.append("A B 5 \n");
		
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", sb.toString());
		assertEquals("Nome válido", malha.getNome());
		assertEquals(2, malha.getPontos().size());
		assertEquals(1, malha.getPontos().get(0).getTrechos().size());
		assertEquals(Double.valueOf(5), malha.getPontos().get(0).getTrechos().get(0).getDistancia());
	}
	
	/**
	 * Test method for {@link br.com.walmart.processador.ProcessadorMalhaLogistica#processar(java.util.List)
	 */
	@Test
	public void testProcessar15() {
		StringBuilder sb1 = new StringBuilder();
		sb1.append("A B 10 \n");
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("A B 5 \n");
		
		Malha malha = ProcessadorMalhaLogistica.processar("Nome válido", sb1.toString());
		Malha malha2 = ProcessadorMalhaLogistica.processar("Nome válido2", sb2.toString());
		
		Malha malhaResultado = ProcessadorMalhaLogistica.processar(Arrays.asList(malha, malha2));
		assertEquals("Nome válido", malhaResultado.getNome());
		assertEquals(2, malha.getPontos().size());
		assertEquals(Double.valueOf(5), malha.getPontos().get(0).getTrechos().get(0).getDistancia());
	}
	

	/*
	 * Testa se o ponto A foi corretamente carregado.
	 * 
	 * @param malha A malha que contém o ponto A.
	 */
	private void testPontoA(Malha malha) {
		for (Ponto ponto : malha.getPontos()) {
			if ("A".equals(ponto.getNome())) {
				assertEquals(2, ponto.getTrechos().size());
				assertEquals("B", ponto.getTrechos().get(0).getPontoDestino().getNome());
				assertEquals(Double.valueOf(10), ponto.getTrechos().get(0).getDistancia());
				assertEquals("C", ponto.getTrechos().get(1).getPontoDestino().getNome());
				assertEquals(Double.valueOf(20), ponto.getTrechos().get(1).getDistancia());
			}
		}
	}

	/*
	 * Testa se o ponto B foi corretamente carregado.
	 * 
	 * @param malha A malha que contém o ponto B.
	 */
	private void testPontoB(Malha malha) {
		for (Ponto ponto : malha.getPontos()) {
			if ("B".equals(ponto.getNome())) {
				assertEquals(2, ponto.getTrechos().size());
				assertEquals("D", ponto.getTrechos().get(0).getPontoDestino().getNome());
				assertEquals(Double.valueOf(15), ponto.getTrechos().get(0).getDistancia());
				assertEquals("E", ponto.getTrechos().get(1).getPontoDestino().getNome());
				assertEquals(Double.valueOf(50), ponto.getTrechos().get(1).getDistancia());
			}
		}
	}

	/*
	 * Testa se o ponto C foi corretamente carregado.
	 * 
	 * @param malha A malha que contém o ponto C.
	 */
	private void testPontoC(Malha malha) {
		for (Ponto ponto : malha.getPontos()) {
			if ("C".equals(ponto.getNome())) {
				assertEquals(1, ponto.getTrechos().size());
				assertEquals("D", ponto.getTrechos().get(0).getPontoDestino().getNome());
				assertEquals(Double.valueOf(30), ponto.getTrechos().get(0).getDistancia());
			}
		}
	}
	
	/*
	 * Testa se o ponto D foi corretamente carregado.
	 * 
	 * @param malha A malha que contém o ponto D.
	 */
	private void testPontoD(Malha malha) {
		for (Ponto ponto : malha.getPontos()) {
			if ("D".equals(ponto.getNome())) {
				assertEquals(1, ponto.getTrechos().size());
				assertEquals("E", ponto.getTrechos().get(0).getPontoDestino().getNome());
				assertEquals(Double.valueOf(30), ponto.getTrechos().get(0).getDistancia());
			}
		}
	}

	/*
	 * Testa se o ponto E foi corretamente carregado.
	 * 
	 * @param malha A malha que contém o ponto E.
	 */
	private void testPontoE(Malha malha) {
		for (Ponto ponto : malha.getPontos()) {
			if ("E".equals(ponto.getNome())) {
				assertEquals(0, ponto.getTrechos().size());
			}
		}
	}

}
