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
import br.com.walmart.exceptions.WalmartException;

/**
 * Calculador utilitária que implementa o algoritmo de menor caminho de
 * Dijkstra.
 *
 * @author andersonlf@gmail.com
 */
public class CalculadorMenorCaminho {

	/**
	 * Calcula o menor caminho dos pontos especificados no <code>dto</code>. A
	 * malha especificada deve conter os pontos de origem e destino, caso
	 * contrário a excecão <code>WalmartException</code> será lançada.
	 * 
	 * @param malha
	 *            A malha logística.
	 * @param dto
	 *            Os parâmetros para cálculo do menor caminho.
	 * @return O objeto <code>RotaEntrega</code> que contém os pontos, a
	 *         distância e o custo total da rota.
	 * 
	 * @throws WalmartException
	 *             Lançada caso o ponto de origem ou destino não pertençam a
	 *             malha logística ou caso não exista rota entre os pontos.
	 */
	public static RotaEntrega calcularMenorCaminho(Malha malha,
			ParametrosEntrega dto) throws WalmartException {

		RotaEntrega rota = new RotaEntrega();
		rota.setAutonomia(dto.getAutonomiaVeiculo());
		rota.setValor(dto.getValorLitroCombustivel());

		Ponto origem = obterPonto(malha, dto.getOrigem());
		Ponto destino = obterPonto(malha, dto.getDestino());

		return calcularMenorCaminhoEntrePontos(origem, destino, malha, rota);
	}

	/*
	 * Reupera o ponto com o nome especificado da malha de pontos especificada.
	 * 
	 * @param malha A malha onde o ponto está inserido.
	 * 
	 * @param nomePonto O nome do ponto.
	 * 
	 * @return O ponto com o nome especificado.
	 * 
	 * @throws WalmartException Lançada caso o ponto não exista.
	 */
	private static Ponto obterPonto(Malha malha, String nomePonto)
			throws WalmartException {
		Ponto ponto = malha.obterPonto(nomePonto);
		
		if (ponto == null) {
			throw new WalmartException("O ponto '" + nomePonto
					+ "' especificado não existe!");
		}
		
		return ponto;
	}

	/*
	 * Calcula o menor caminho entre dois pontos.
	 * 
	 * @param origem Ponto de partida.
	 * 
	 * @param destino Destino
	 * 
	 * @param malha A malha que contém os dois pontos.
	 * 
	 * @return A rota com o menor caminho e o custo.
	 * 
	 * @throws WalmartException Lançada caso não exista rota entre os pontos.
	 */
	private static RotaEntrega calcularMenorCaminhoEntrePontos(Ponto origem,
			Ponto destino, Malha malha, RotaEntrega rota) throws WalmartException {

		List<Ponto> visitados = new ArrayList<Ponto>(malha.getPontos());
		Map<Ponto, Double> distancias = criarMapaDistancias(malha.getPontos());
		Map<Ponto, Ponto> antecessores = new HashMap<Ponto, Ponto>();

		visitados.remove(origem);
		distancias.put(origem, 0d);
		antecessores.put(destino, null);

		calcularDistanciasAntecessores(origem, distancias, antecessores);
		while (!visitados.isEmpty()) {
			Ponto pontoMenorDistancia = recuperarPontoMenorDistancia(distancias, visitados);
			
			if (pontoMenorDistancia == null) {
				throw new WalmartException("Não existe rota da origem '" + origem + "' para o destino '" + destino + "' ou existem pontos que não possuem ligações entre eles!");
			}
			
			calcularDistanciasAntecessores(pontoMenorDistancia, distancias,
					antecessores);
			visitados.remove(pontoMenorDistancia);
		}

		rota.setDistanciaRota(distancias.get(destino));
		Ponto precedente = destino;
		do {
			rota.getRota().add(precedente.getNome());
			precedente = antecessores.get(precedente);
		} while (precedente != null);

		return rota;
	}
	
	/*
	 * Calcula a menor estimativa dos pontos especificados.
	 * 
	 * @param visitados A lista de todos os pontos.
	 * 
	 * @param distancias O mapa com as distancias entre os pontos
	 * 
	 * @return O ponto com menor distância 
	 */
	private static Ponto recuperarPontoMenorDistancia(Map<Ponto, Double> distancias,
			List<Ponto> visitados) {
		double maiorDistancia = Double.MAX_VALUE;
		Ponto candidato = null;
		for (Ponto visitado : visitados) {
			double distancia = distancias.get(visitado);
			if (distancia < maiorDistancia) {
				maiorDistancia = distancia;
				candidato = visitado;
			}
		}
		return candidato;
	}
	
	/*
	 * Calcula a distancia do ponto especificado para os seus trechos. Atualiza
	 * se necessário o mapa de distâncias e precedentes.
	 * 
	 * @param ponto O ponto a partir de onde se deseja calcular as distâncias.
	 * 
	 * @param distancias O mapa com as distancias entre os pontos.
	 * 
	 * @param precedentes O mapa da melhor rota entre dois pontos.
	 */
	private static void calcularDistanciasAntecessores(Ponto ponto,
			Map<Ponto, Double> distancias, Map<Ponto, Ponto> precedentes) {

		for (Trecho trecho : ponto.getTrechos()) {
			Ponto outroPonto = trecho.getPontoDestino();

			Double distanciaAtual = distancias.get(ponto)
					+ trecho.getDistancia();
			Double distanciaAnterior = distancias.get(outroPonto);

			if (distanciaAtual < distanciaAnterior) {
				distancias.put(outroPonto, distanciaAtual);
				precedentes.put(outroPonto, ponto);
			}
		}
	}

	/*
	 * Inicializa o mapa de distancias com o maior valor possível.
	 * 
	 * @param pontos Pontos que serão inseridos no mapa.
	 * 
	 * @return Um mapa com todos os pontos e a maior distância possível para
	 * eles.
	 */
	private static Map<Ponto, Double> criarMapaDistancias(List<Ponto> pontos) {
		Map<Ponto, Double> distancias = new HashMap<Ponto, Double>();
		for (Ponto ponto : pontos) {
			distancias.put(ponto, Double.MAX_VALUE);
		}
		return distancias;
	}

}
