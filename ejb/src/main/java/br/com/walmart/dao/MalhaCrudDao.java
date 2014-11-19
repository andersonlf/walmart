/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.WalmartException;

/**
 * A implementação de um DAO para manipular malhas.
 *
 * @author andersonlf@gmail.com
 */
public class MalhaCrudDao extends WalmartCrudDaoAbstract<Malha> implements IMalhaCrudDao {
	
	public MalhaCrudDao(EntityManager em) {
		super(Malha.class, em);
	}
	
	/* (non-Javadoc)
	 * @see br.com.walmart.dao.WalmartCrudDaoAbstract#verificarDuplicidade(br.com.walmart.entidades.WalmartEntidade)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void verificarDuplicidade(Malha objeto) throws WalmartException {
		Query query = getEntityManager().createNamedQuery("findMalhaByNome");
		query.setParameter("nome", objeto.getNome());

		List<Malha> malhas = query.getResultList();
		
		if (malhas.size() > 0) {
			throw new WalmartException("Malha '" + objeto.getNome() + "' já está cadastrada!");
		}
	}

}
