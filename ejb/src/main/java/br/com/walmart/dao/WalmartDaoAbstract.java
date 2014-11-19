/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Super classe para todas as implementações de DAO do projeto.
 *
 * @author andersonlf@gmail.com
 */
public abstract class WalmartDaoAbstract implements IWalmartDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(WalmartDaoAbstract.class);

	private EntityManager em;

	/**
	 * Construtor para todos os DAOs do projeto.
	 * 
	 * @param em EntityManager para realizar as operações de persistência.
	 */
	public WalmartDaoAbstract(EntityManager em) {
		this.em = em;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.dao.IWalmartCrudDao#getEntityManager()
	 */
	@Override
	public EntityManager getEntityManager() {
		return this.em;
	}

	/**
	 * Método JavaBean para obter o logger.
	 * 
	 * @return O logger desta classe.
	 */
	protected static Logger getLogger() {
		return LOGGER;
	}

}
