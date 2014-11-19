/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Super classe de serviço para o projeto.
 * 
 * @author andersonlf@gmail.com
 */
public abstract class WalmartServicoAbstract implements IWalmartServico {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WalmartServicoAbstract.class);

	/**
	 * Método JavaBean para obter o logger.
	 * 
	 * @return O logger desta classe.
	 */
	protected static Logger getLogger() {
		return LOGGER;
	}
	
}
