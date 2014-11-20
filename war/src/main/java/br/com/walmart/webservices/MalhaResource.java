/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.webservices;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import br.com.walmart.ejb.IMalhaCrudServico;
import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.WalmartException;
import br.com.walmart.processador.ProcessadorMalhaLogistica;

/**
 * RESTFul Web Services para operações com malhas.
 * 
 * @author andersonlf@gmail.com
 */
@Path("malha")
public class MalhaResource extends WalmartResource {

	@Context
	private UriInfo context;

	@EJB
	private IMalhaCrudServico malhaCrudServico;

	public MalhaResource() {
	}

	/**
	 * Método responsável por incluir uma malha. 
	 * 
	 * @param nome
	 *            Nome da malha a ser incluída.
	 * @param malha
	 *            Malha a ser incluída. O formato de malha logística é bastante
	 *            simples, cada linha mostra uma rota: ponto de origem, ponto de
	 *            destino e distância entre os pontos em quilômetros. Exemplo:
	 *            <pre>
	 *            A B 10
	 *            B D 15
	 *            A C 20
	 *            C D 30
	 *            B E 50
	 *            D E 30
	 *            </pre>
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	public String incluir(@FormParam("nome") String nome,
			@FormParam("malha") String malha) {
		getLogger().info("> incluir");
		getLogger().info(
				">> parametros: nome='" + nome + "' malha='" + malha + "'");
		Malha malhaObject = ProcessadorMalhaLogistica.processar(nome, malha);
		getLogger().info(">> malha criada: " + malhaObject);

		String retorno = "1";
		try {
			malhaCrudServico.incluir(malhaObject);
		} catch (WalmartException e) {
			retorno = "0";
			getLogger().error(e.getMessage(), e);
		}

		return retorno;
	}

}