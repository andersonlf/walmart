/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.webservices;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.dto.RotaEntrega;
import br.com.walmart.ejb.ILogisticaServico;
import br.com.walmart.exceptions.WalmartException;

/**
 * RESTFul Web Services para operações logísticas.
 * 
 * @author andersonlf@gmail.com
 */
@Path("rotamenorcusto")
public class LogisticaResource extends WalmartResource {

	@Context
	private UriInfo context;

	@EJB
	private ILogisticaServico logisticaServico;

	public LogisticaResource() {
	}

	/**
	 * Método responsável por calcular o melhor caminho a partir da origem e
	 * destino especificados, considerando autonomia do transporte e o valor. O
	 * retorno informa a rota e o custo. Considere a malha abaixo:
	 * <pre>
	 * A B 10
	 * B D 15
	 * A C 20
	 * C D 30
	 * B E 50
	 * D E 30
	 * </pre>
	 * 
	 * Um exemplo de entrada para cálculo do melhor caminho seria, origem A,
	 * destino D, autonomia 10, valor do litro 2,50; a resposta seria a rota A B
	 * D com custo de 6,25.
	 * 
	 * @param malha
	 *            O nome da malha.
	 * @param origem
	 *            Ponto de partida para uma entrega.
	 * @param destino
	 *            Ponto de destino para uma entrega.
	 * @param autonomia
	 *            Autonomia do veículo usado para transporte. A unidade está em
	 *            km/l.
	 * @param valor
	 *            Valor do litro de combustível usado pelo veículo de
	 *            transporte.
	 */
	@GET
	@Path("/{malha}/{origem}/{destino}/{autonomia}/{valor}")
	@Produces(MediaType.TEXT_HTML)
	public String calcularMelhorCaminho(@PathParam("malha") String malha,
			@PathParam("origem") String origem,
			@PathParam("destino") String destino,
			@PathParam("autonomia") double autonomia,
			@PathParam("valor") double valor) {

		getLogger().info("> calcularMelhorCaminho");
		getLogger().info(
				">> parametros: malha='" + malha + "' origem='" + origem
						+ "' destino='" + destino + "' autonomia='" + autonomia
						+ "' valor='" + valor + "'");

		ParametrosEntrega dto = new ParametrosEntrega();
		dto.setMalha(malha);
		dto.setOrigem(origem);
		dto.setDestino(destino);
		dto.setAutonomiaVeiculo(autonomia);
		dto.setValorLitroCombustivel(valor);

		String retorno = null;
		try {
			RotaEntrega rota = logisticaServico.calcularRotaMenorCusto(dto);
			retorno = rota.toString();
			getLogger().info(">> rota: " + retorno);
		} catch (WalmartException e) {
			retorno = e.getMessage();
			getLogger().error(e.getMessage(), e);
		}

		return retorno;
	}

}