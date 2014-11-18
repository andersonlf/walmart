/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.dto.RotaEntrega;

/**
 * Interface para operações de cálculo do menor caminho.
 * 
 * @author andersonlf@gmail.com
 */
public interface ILogistica {

	/**
	 * Método responsável por calcular o menor caminho entre dois pontos.
	 * 
	 * @param dto
	 *            Contém as informações de entrega: ponto de origem, ponto de
	 *            destino, autonomia do veículo usado para entrega e valor do
	 *            litro de combustível usado pelo veículo de entrega.
	 * 
	 * @return O objeto <code>Rota</code> que contém as informações do menor
	 *         caminho de entrega e o custo da entrega de acordo com a autonomia
	 *         do veículo usado para entrega e o valor do combustível.
	 */
	public RotaEntrega calcularMenorCaminho(ParametrosEntrega dto);

}
