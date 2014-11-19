/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import javax.persistence.EntityManager;

/**
 * Super interface dos DAOs para o projeto.
 *
 * @author andersonlf@gmail.com
 */
public interface IWalmartDao {

	/**
	 * Método para recuperar o <code>EntityManager</code> configurado para o
	 * DAO.
	 * 
	 * @returno O <code>EntityManager</code> configurado para o DAO.
	 */
	EntityManager getEntityManager();

}
