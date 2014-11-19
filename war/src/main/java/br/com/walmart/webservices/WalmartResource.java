/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Super classe para todos os RESTFul Web Services
 *
 * @author andersonlf@gmail.com
 */
public class WalmartResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WalmartResource.class);
	
	/*
	 * Método JavaBean para obter o logger.
	 * 
	 * @return O logger desta classe.
	 */
	public static Logger getLogger() {
		return LOGGER;
	}

}
