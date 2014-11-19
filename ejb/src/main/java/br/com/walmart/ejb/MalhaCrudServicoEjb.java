/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.walmart.dao.IMalhaCrudDao;
import br.com.walmart.dao.WalmartDaoFactory;
import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.MalhaJaExisteException;

/**
 * Serviço EJB responsável pelas operações CRUD de uma malha.
 * 
 * @author andersonlf@gmail.com
 */
@Stateless
@Local(IMalhaCrudServico.class)
public class MalhaCrudServicoEjb implements IMalhaCrudServico {

	@PersistenceContext(unitName = "emWalmart")
	private EntityManager entityManager;
	
	private IMalhaCrudDao dao;

	@EJB
	private ILogisticaServico logistica;
	
	/*
	 * Método utilizado para inicializar os daos. 
	 */
	@PostConstruct
	private void inicializarDao() {
		dao = WalmartDaoFactory.getInstance().criarMalhaCrudDao(entityManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.ejb.IMalhaCrudServico#incluir(br.com.walmart.entidades.Malha)
	 */
	@Override
	public boolean incluir(Malha malha) throws MalhaJaExisteException {
		Malha outraMalha = obter(malha.getNome());

		if (outraMalha != null) {
			throw new MalhaJaExisteException("Malha com nome '"
					+ malha.getNome() + "' já existe!");
		}

		logistica.setMalha(malha);
		dao.incluir(malha);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.ejb.IMalhaCrudServico#obter(java.io.Serializable)
	 */
	@Override
	public Malha obter(Serializable chave) {
		return dao.obter(chave);
	}

}
