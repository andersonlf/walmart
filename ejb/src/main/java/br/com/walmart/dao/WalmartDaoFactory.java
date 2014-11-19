/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import javax.persistence.EntityManager;

/**
 * Singleton para fabricar DAOs do projeto.
 *
 * @author andersonlf@gmail.com
 */
public class WalmartDaoFactory {
	
	private static WalmartDaoFactory instancia = new WalmartDaoFactory();
	
	private WalmartDaoFactory() {}
	
	/**
	 * Método para recuperar a instância única da classe.
	 * @return A única instância de <code>WalmartDaoFactory</code>.
	 */
	public static WalmartDaoFactory getInstance() {
		return instancia;
	}

	/**
	 * Factory Method para criação de <code>MalhaCrudDao</code>.
	 * @return Uma nova instância de <code>MalhaCrudDao</code>.
	 */
	public IMalhaCrudDao criarMalhaCrudDao(EntityManager em) {
		return new MalhaCrudDao(em);
	}

}
