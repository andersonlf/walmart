/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.walmart.dao.IMalhaCrudDao;
import br.com.walmart.dao.IWalmartCrudDao;
import br.com.walmart.dao.WalmartDaoFactory;
import br.com.walmart.entidades.Malha;

/**
 * Serviço EJB responsável pelas operações CRUD de uma malha.
 * 
 * @author andersonlf@gmail.com
 */
@Stateless
@Local(IMalhaCrudServico.class)
public class MalhaCrudServicoEjb extends WalmartCrudServicoAbstract<Malha> implements IMalhaCrudServico {

	private IMalhaCrudDao dao;

	@PersistenceContext(unitName = "emWalmart")
	private EntityManager entityManager;

	@EJB
	private ILogisticaServico logistica;
	
	/*
	 * Método utilizado para inicializar os daos. 
	 */
	@PostConstruct
	protected void inicializarDao() {
		dao = WalmartDaoFactory.getInstance().criarMalhaCrudDao(entityManager);
	}

	/* (non-Javadoc)
	 * @see br.com.walmart.ejb.IWalmartCrudServico#getDao()
	 */
	@Override
	public IWalmartCrudDao<Malha> getDao() {
		return this.dao;
	}

}
