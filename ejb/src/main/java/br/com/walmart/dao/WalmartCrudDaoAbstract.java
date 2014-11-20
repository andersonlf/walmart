/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.walmart.entidades.WalmartEntidade;
import br.com.walmart.exceptions.WalmartException;

/**
 * Super classe para todas as implementações de CRUD DAO do projeto.
 *
 * @author andersonlf@gmail.com
 */
public abstract class WalmartCrudDaoAbstract<T extends WalmartEntidade> extends
		WalmartDaoAbstract implements IWalmartCrudDao<T> {

	private Class<T> clazz;

	/**
	 * Construtor para todos os CRUD DAOs do projeto.
	 * 
	 * @param clazz
	 *            Nome da classe a qual pertence.
	 * @param em
	 *            EntityManager para realizar as operações de persistência.
	 */
	public WalmartCrudDaoAbstract(Class<T> clazz, EntityManager em) {
		super(em);
		this.clazz = clazz;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.dao.IWalmartCrudDao#incluir(br.com.walmart.entidades.
	 * WalmartEntidade)
	 */
	@Override
	public T incluir(T objeto) throws WalmartException {
		verificarDuplicidade(objeto);
		getEntityManager().persist(objeto);
		getEntityManager().flush();
		getEntityManager().detach(objeto);
		return objeto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.dao.IWalmartCrudDao#excluir(java.io.Serializable)
	 */
	@Override
	public void excluir(Serializable chave) throws WalmartException {
		getLogger().error("Método não implementado!");
		throw new WalmartException("Método não implementado!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.dao.IWalmartCrudDao#alterar(br.com.walmart.entidades.
	 * WalmartEntidade)
	 */
	@Override
	public void alterar(T objeto) throws WalmartException {
		getLogger().error("Método não implementado!");
		throw new WalmartException("Método não implementado!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.dao.IWalmartCrudDao#listar()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> listar() throws WalmartException {
		Query query = getEntityManager().createQuery("from " + clazz.getCanonicalName());
		List<T> objs = query.getResultList();
		
		for (T obj : objs) {
			getEntityManager().detach(obj);
		}
		
		return objs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.dao.IWalmartCrudDao#obter(java.io.Serializable)
	 */
	@Override
	public T obter(Serializable chave) throws WalmartException {
		getLogger().info(
				"Recuperando " + clazz + " '" + chave + "' do banco de dados.");
		return getEntityManager().find(clazz, chave);
	}

	/**
	 * Método utilizado para verificar se um item já está incluído no banco de
	 * dados.
	 * 
	 * @param objeto O objeto que será verificado no banco de dados. 
	 * 
	 * @throws WalmartException Lançada se o objeto já está cadastrado.
	 */
	protected void verificarDuplicidade(T objeto) throws WalmartException {
	}

}
