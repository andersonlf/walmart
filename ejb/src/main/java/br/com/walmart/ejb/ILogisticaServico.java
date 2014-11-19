/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.dto.RotaEntrega;
import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.PontoInexistenteException;

/**
 * Interface para operações de cálculo da rota de menor custo.
 * 
 * @author andersonlf@gmail.com
 */
public interface ILogisticaServico {

	/**
	 * Método responsável por calcular a rota de menor custo. Uma rota de menor
	 * custo é aquela que o veículo de entrega percorre menos kilômetros,
	 * consumindo menos combustível.
	 * 
	 * @param dto
	 *            Contém as informações de entrega: ponto de origem, ponto de
	 *            destino, autonomia do veículo usado para entrega e valor do
	 *            litro de combustível usado pelo veículo de entrega.
	 * 
	 * @return O objeto <code>Rota</code> que contém as informações do menor
	 *         caminho de entrega e o custo da entrega de acordo com a autonomia
	 *         do veículo usado para entrega e o valor do combustível.
	 * @throws PontoInexistenteException
	 *             Essa exceção é lançada quando um dos pontos, origem ou
	 *             destino, não existem na malha.
	 */
	public RotaEntrega calcularRotaMenorCusto(ParametrosEntrega dto)
			throws PontoInexistenteException;

	/**
	 * Método JavaBean.
	 * 
	 * @param malha
	 *            O novo valor da malha.
	 */
	public void setMalha(Malha malha);

}
