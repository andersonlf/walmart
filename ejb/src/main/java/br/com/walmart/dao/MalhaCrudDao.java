/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.walmart.entidades.Malha;

/**
 * A implementação de um DAO para manipular malhas.
 *
 * @author andersonlf@gmail.com
 */
public class MalhaCrudDao implements IMalhaCrudDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MalhaCrudDao.class);

	private EntityManager em;

	/**
	 * Cria um <code>MalhaCrudDao</code> com um <code>EntityManager</code>.
	 * 
	 * @param em
	 *            O <code>EntityManager</code> para realizar as operações de
	 *            persistência.
	 */
	public MalhaCrudDao(EntityManager em) {
		this.em = em;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.walmart.dao.IMalhaCrudDao#incluir(br.com.walmart.entidades.Malha)
	 */
	@Override
	public void incluir(Malha malha) {
		getLogger().info("Malha '" + malha.toString() + "' persistida.");
		em.persist(malha);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.dao.IMalhaCrudDao#obter(java.io.Serializable)
	 */
	@Override
	public Malha obter(Serializable chave) {
		getLogger().info("Recuperando malha '" + chave + "' do banco de dados.");
		return em.find(Malha.class, chave);
	}
	
	/*
	 * Método JavaBean para obter o logger.
	 * @return O logger desta classe.
	 */
	public static Logger getLogger() {
		return LOGGER;
	}

}
