/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.walmart.ejb.IMalha;
import br.com.walmart.entidades.Malha;
import br.com.walmart.entidades.Trecho;

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
	private IMalha malhaCrudServico;

	public MalhaResource() {
	}
	
	/**
	 * Método responsável por obter uma malha. 
	 * TODO D situações de erro 
	 * TODO D limites e valores aceitáveis
	 * 
	 * @param nome
	 *            Nome da malha a ser obtida.
	 */
	@GET
	@Path("/{nome}")
	public String obter(@PathParam ("nome") String nome) {
		
		getLogger().info("> obter");
		getLogger().info(">> parametros: nome='" + nome + "'");
		
		// TODO C obter malha
		return nome;
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
	public void incluir(@FormParam("nome") String nome,
			@FormParam("malha") String malha) {

		getLogger().info("> incluir");
		getLogger().debug(">> parametros: nome='" + nome + "' malha='" + malha + "'");
		
		List<Trecho> trechos = new ArrayList<Trecho>();
		
		Malha omalha = new Malha();
		omalha.setNome(nome);
		omalha.setTrechos(trechos);
		
		String[] linhas = malha.split("\n");
		for (String trecho : linhas) {
			String[] pontos = trecho.split(" ");
			
			Trecho otrecho = new Trecho();
			otrecho.setOrigem(pontos[0]);
			otrecho.setDestino(pontos[1]);
			otrecho.setDistancia(Double.parseDouble(pontos[2]));
			
			trechos.add(otrecho);
		}
		
		malhaCrudServico.incluir(omalha);
	}

	/**
	 * Método responsável por atualizar uma malha. 
	 * TODO D situações de erro 
	 * TODO D limites e valores aceitáveis
	 * 
	 * @param nome
	 *            Nome da malha a ser atualizada.
	 * @param malha
	 *            Malha a ser atualizada. Para mais informações sobre o formato 
	 *            da malha veja {@link #incluir(String, String)}.
	 */
	@PUT
	public void atualizar(@FormParam("nome") String nome,
			@FormParam("malha") String malha) {
		
		getLogger().info("> atualizar");
		getLogger().debug(">> parametros: nome='" + nome + "' malha='" + malha + "'");
		
		// TODO C persistir malha
	}
	
	/**
	 * Método responsável por excluir uma malha. 
	 * TODO D situações de erro 
	 * TODO D limites e valores aceitáveis
	 * 
	 * @param nome
	 *            Nome da malha a ser excluída.
	 */
	@DELETE
	@Path("/{nome}")
	public void excluir(@PathParam("nome") String nome) {

		getLogger().info("> atualizar");
		getLogger().info(">> parametros: nome='" + nome + "'");
		
		// TODO C persistir malha
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