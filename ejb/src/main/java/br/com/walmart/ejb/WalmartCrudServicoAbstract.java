/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import java.io.Serializable;
import java.util.List;

import br.com.walmart.entidades.WalmartEntidade;
import br.com.walmart.exceptions.WalmartException;

/**
 * Super classe de serviço de CRUD para o projeto.
 * 
 * @author andersonlf@gmail.com
 */
public abstract class WalmartCrudServicoAbstract<T extends WalmartEntidade>
		extends WalmartServicoAbstract implements IWalmartCrudServico<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.walmart.ejb.IWalmartCrudServico#incluir(br.com.walmart.entidades
	 * .WalmartEntidade)
	 */
	@Override
	public T incluir(T objeto) throws WalmartException {
		return getDao().incluir(objeto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.ejb.IWalmartCrudServico#excluir(java.io.Serializable)
	 */
	@Override
	public void excluir(Serializable chave) throws WalmartException {
		getDao().excluir(chave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.walmart.ejb.IWalmartCrudServico#alterar(br.com.walmart.entidades
	 * .WalmartEntidade)
	 */
	@Override
	public void alterar(T objeto) throws WalmartException {
		getDao().alterar(objeto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.ejb.IWalmartCrudServico#listar()
	 */
	@Override
	public List<T> listar() throws WalmartException {
		return getDao().listar();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.walmart.ejb.IWalmartCrudServico#obter(java.io.Serializable)
	 */
	@Override
	public T obter(Serializable chave) throws WalmartException {
		return getDao().obter(chave);
	}

}
