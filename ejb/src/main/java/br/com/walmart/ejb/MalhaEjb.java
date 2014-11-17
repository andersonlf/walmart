/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.walmart.entidades.Malha;

/**
 * Serviço EJB responsável pelas operações CRUD de uma malha. 
 * 
 * @author andersonlf@gmail.com
 */
@Stateless
@Local(IMalha.class)
public class MalhaEjb implements IMalha {

	@PersistenceContext(unitName = "emWalmart")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * @see br.com.walmart.ejb.IMalha#incluir(br.com.walmart.entidades.Malha)
	 */
	@Override
	public boolean incluir(Malha malha) {
		entityManager.persist(malha);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.walmart.ejb.IMalha#atualizar(br.com.walmart.entidades.Malha)
	 */
	@Override
	public boolean atualizar(Malha malha) {
		entityManager.merge(malha);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.walmart.ejb.IMalha#exluir(java.io.Serializable)
	 */
	@Override
	public boolean exluir(Serializable chave) {
		Malha malha = obter(chave);

		if (malha != null) {
			entityManager.remove(malha);
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.walmart.ejb.IMalha#obter(java.io.Serializable)
	 */
	@Override
	public Malha obter(Serializable chave) {
		return entityManager.find(Malha.class, chave);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.walmart.ejb.IMalha#listar()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Malha> listar() {
		Query query = entityManager.createQuery("from br.com.walmart.entidades.Malha");
		return (List<Malha>) query.getResultList();
	}
}
