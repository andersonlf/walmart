/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.webservices;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.walmart.ejb.IMalhaCrud;
import br.com.walmart.entidades.Malha;
import br.com.walmart.processador.ProcessadorMalhaLogistica;

/**
 * RESTFul Web Services para operações com malhas.
 * 
 * @author andersonlf@gmail.com
 */
@Path("malha")
public class MalhaResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(MalhaResource.class);

	@Context
	private UriInfo context;
	
	@EJB
	private IMalhaCrud malhaCrudServico;

	public MalhaResource() {
	}
	
	/**
	 * Método responsável por incluir uma malha. 
	 * TODO D situações de erro 
	 * TODO D limites e valores aceitáveis
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
	public void incluir(@FormParam("nome") String nome, @FormParam("malha") String malha) {
		getLogger().info("> incluir");
		getLogger().debug(">> parametros: nome='" + nome + "' malha='" + malha + "'");
		Malha malhaObject = ProcessadorMalhaLogistica.processar(nome, malha);
		getLogger().debug(">> malha criada: " + malhaObject);
		malhaCrudServico.incluir(malhaObject);
	}


	/*
	 * Método JavaBean para obter o logger.
	 * 
	 * @return O logger desta classe.
	 */
	private static Logger getLogger() {
		return LOGGER;
	}

}