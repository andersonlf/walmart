/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.dto.RotaEntrega;
import br.com.walmart.entidades.Malha;
import br.com.walmart.entidades.Ponto;
import br.com.walmart.entidades.Trecho;
import br.com.walmart.exceptions.PontoInexistenteException;

/**
 * Calculador de menor caminho usando o algoritmo Dijkstra.
 *
 * @author andersonlf@gmail.com
 */
public class CalculadorMenorCaminho {
	
	public static RotaEntrega calcularMenorCaminho(Malha malha, ParametrosEntrega dto) throws PontoInexistenteException {
		RotaEntrega rota = new RotaEntrega();
		rota.setAutonomia(dto.getAutonomiaVeiculo());
		rota.setValor(dto.getValorLitroCombustivel());
		
		Ponto origem = null;
		Ponto destino = null;
		for (Ponto ponto : malha.getPontos()) {
			if (ponto.getNome().equals(dto.getOrigem())) {
				origem = ponto;
			}

			if (ponto.getNome().equals(dto.getDestino())) {
				destino = ponto;
			}
		}
		
		if (origem == null) {
			throw new PontoInexistenteException("O ponto de origem '" + dto.getOrigem() + "' especificado não existe!");
		} else if (destino == null) {
			throw new PontoInexistenteException("O ponto de destino '" + dto.getDestino() + "' especificado não existe!");
		}
		
		return calcularMenorCaminhoEntrePontos(origem, destino, malha, rota);
	}

	/*
	 * Calcula o menor caminho entre dois pontos.
	 * 
	 * @param origem Ponto de partida.
	 * @param destino Destino
	 * @param malha A malha que contém os dois pontos.
	 * @return A rota com o menor caminho e o custo.
	 */
	private static RotaEntrega calcularMenorCaminhoEntrePontos(Ponto origem, Ponto destino, Malha malha, RotaEntrega rota) {
		List<Ponto> abertos = new ArrayList<Ponto>(malha.getPontos());

		Map<Ponto, Double> estimativas = new HashMap<Ponto, Double>();
		Map<Ponto, Ponto> precedentes = new HashMap<Ponto, Ponto>();

		for (Ponto ponto : malha.getPontos()) {
			estimativas.put(ponto, Double.MAX_VALUE);
		}

		estimativas.put(origem, 0d);
		precedentes.put(destino, null);

		fechar(origem, estimativas, precedentes);
		abertos.remove(origem);

		while (!abertos.isEmpty()) {
			Ponto menorEstimativa = menorEstimativa(abertos, estimativas);
			fechar(menorEstimativa, estimativas, precedentes);
			abertos.remove(menorEstimativa);
		}

		rota.setDistanciaRota(estimativas.get(destino));
		Ponto precedente = destino;
		do {
			rota.getRota().add(precedente.getNome());
			precedente = precedentes.get(precedente);
		} while (precedente != null);

		return rota;
	}

	private static Ponto menorEstimativa(List<Ponto> abertos, Map<Ponto, Double> estimativas) {
		double custo = Double.MAX_VALUE;
		Ponto candidato = null;
		for (Ponto aberto : abertos) {
			double estimativa = estimativas.get(aberto);
			if (estimativa < custo) {
				custo = estimativa;
				candidato = aberto;
			}
		}
		return candidato;
	}

	private static void fechar(Ponto ponto, Map<Ponto, Double> estimativas, Map<Ponto, Ponto> precedentes) {
		Double estimativaRaiz = estimativas.get(ponto);

		for (Trecho trecho : ponto.getTrechos()) {
			Ponto outroPonto = trecho.getPontoDestino();
			Double estimativa = estimativaRaiz + trecho.getDistancia();
			double estimativaAnterior = estimativas.get(outroPonto);

			if (estimativaAnterior > estimativa) {
				estimativas.put(outroPonto, estimativa);
				precedentes.put(outroPonto, ponto);
			}
		}
	}

}
