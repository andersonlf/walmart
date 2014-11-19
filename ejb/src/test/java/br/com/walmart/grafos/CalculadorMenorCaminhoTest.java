/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.grafos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.WalmartException;
import br.com.walmart.processador.ProcessadorMalhaLogistica;

/**
 * Teste unitário da classe utilitária CalculadorMenorCaminho.
 * 
 * @author andersonlf@gmail.com
 */
public class CalculadorMenorCaminhoTest {
	
	private Malha malha;
	
	/**
	 * Test method for {@link br.com.walmart.grafos.CalculadorMenorCaminho#calcularMenorCaminho(br.com.walmart.entidades.Malha, br.com.walmart.dto.ParametrosEntrega)}.
	 */
	@Test
	public void testCalcularMenorCaminho() {
		ParametrosEntrega dto = new ParametrosEntrega();
		dto.setAutonomiaVeiculo(10d);
		dto.setDestino("D");
		dto.setOrigem("A");
		dto.setValorLitroCombustivel(2.5);
	
		try {
			assertEquals("A B D 6.25", CalculadorMenorCaminho.calcularMenorCaminho(malha, dto).toString());
		} catch (WalmartException e) {
			fail("Não deveria lançar exceção.");
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link br.com.walmart.grafos.CalculadorMenorCaminho#calcularMenorCaminho(br.com.walmart.entidades.Malha, br.com.walmart.dto.ParametrosEntrega)}.
	 */
	@Test
	public void testCalcularMenorCaminho2() {
		ParametrosEntrega dto = new ParametrosEntrega();
		dto.setAutonomiaVeiculo(10d);
		dto.setDestino("A");
		dto.setOrigem("A");
		dto.setValorLitroCombustivel(2.5);
		
		try {
			assertEquals("A 0.0", CalculadorMenorCaminho.calcularMenorCaminho(malha, dto).toString());
		} catch (WalmartException e) {
			fail("Não deveria lançar exceção.");
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link br.com.walmart.grafos.CalculadorMenorCaminho#calcularMenorCaminho(br.com.walmart.entidades.Malha, br.com.walmart.dto.ParametrosEntrega)}.
	 */
	@Test
	public void testCalcularMenorCaminho3() {
		ParametrosEntrega dto = new ParametrosEntrega();
		dto.setAutonomiaVeiculo(10d);
		dto.setOrigem("A");
		dto.setDestino("J");
		dto.setValorLitroCombustivel(2.5);

		try {
			assertEquals("A 0", CalculadorMenorCaminho.calcularMenorCaminho(malha, dto).toString());
			fail("Deveria lançar exceção.");
		} catch (WalmartException e) {
			assertEquals("O ponto '" + dto.getDestino() + "' especificado não existe!", e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link br.com.walmart.grafos.CalculadorMenorCaminho#calcularMenorCaminho(br.com.walmart.entidades.Malha, br.com.walmart.dto.ParametrosEntrega)}.
	 */
	@Test
	public void testCalcularMenorCaminho4() {
		ParametrosEntrega dto = new ParametrosEntrega();
		dto.setAutonomiaVeiculo(10d);
		dto.setOrigem("J");
		dto.setDestino("A");
		dto.setValorLitroCombustivel(2.5);

		try {
			assertEquals("A 0", CalculadorMenorCaminho.calcularMenorCaminho(malha, dto).toString());
			fail("Deveria lançar exceção.");
		} catch (WalmartException e) {
			assertEquals("O ponto '" + dto.getOrigem() + "' especificado não existe!", e.getMessage());
		}
	}

	/**
	 * Test method for {@link br.com.walmart.grafos.CalculadorMenorCaminho#calcularMenorCaminho(br.com.walmart.entidades.Malha, br.com.walmart.dto.ParametrosEntrega)}.
	 */
	@Test
	public void testCalcularMenorCaminho5() {
		StringBuilder sb = new StringBuilder();
		sb.append("A B 30\n");
		sb.append("A B 20\n");
		sb.append("A B 10\n");
		sb.append("B D 15\n");
		sb.append("A C 20\n");
		sb.append("C D 30\n");
		sb.append("B E 50\n");
		sb.append("D E 30");
		
		Malha outraMalha = ProcessadorMalhaLogistica.processar("TesteMalha", sb.toString());
		
		ParametrosEntrega dto = new ParametrosEntrega();
		dto.setAutonomiaVeiculo(10d);
		dto.setOrigem("A");
		dto.setDestino("D");
		dto.setValorLitroCombustivel(2.5);
		
		try {
			assertEquals("A B D 6.25", CalculadorMenorCaminho.calcularMenorCaminho(outraMalha, dto).toString());
		} catch (WalmartException e) {
			fail("Não deveria lançar exceção.");
		}
	}

	/**
	 * Test method for {@link br.com.walmart.grafos.CalculadorMenorCaminho#calcularMenorCaminho(br.com.walmart.entidades.Malha, br.com.walmart.dto.ParametrosEntrega)}.
	 */
	@Test
	public void testCalcularMenorCaminho6() {
		StringBuilder sb = new StringBuilder();
		sb.append("A B 10\n");
		sb.append("A B 20\n");
		sb.append("A B 5\n");
		sb.append("B D 15\n");
		sb.append("A C 20\n");
		sb.append("C D 30\n");
		sb.append("B E 50\n");
		sb.append("D E 30");
		
		Malha outraMalha = ProcessadorMalhaLogistica.processar("TesteMalha", sb.toString());
		
		ParametrosEntrega dto = new ParametrosEntrega();
		dto.setAutonomiaVeiculo(10d);
		dto.setOrigem("A");
		dto.setDestino("D");
		dto.setValorLitroCombustivel(2.5);
		
		try {
			assertEquals("A B D 5.0", CalculadorMenorCaminho.calcularMenorCaminho(outraMalha, dto).toString());
		} catch (WalmartException e) {
			fail("Não deveria lançar exceção.");
		}
	}
	
	@Before
	public void carregarMalhaLogistica() {
		StringBuilder sb = new StringBuilder();
		sb.append("A B 10\n");
		sb.append("B D 15\n");
		sb.append("A C 20\n");
		sb.append("C D 30\n");
		sb.append("B E 50\n");
		sb.append("D E 30");
		
		this.malha = ProcessadorMalhaLogistica.processar("TesteMalha", sb.toString());
	}
}
