/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import java.io.Serializable;
import java.util.List;

import br.com.walmart.entidades.WalmartEntidade;
import br.com.walmart.exceptions.WalmartException;

/**
 * Super interface das operações de CRUD para o projeto.
 *
 * @author andersonlf@gmail.com
 */
public interface IWalmartCrudDao<T extends WalmartEntidade> extends IWalmartDao {

	/**
	 * Método para incluir um objeto.
	 * 
	 * @param objeto
	 *            o objeto a ser incluído.
	 * @throws WalmartException
	 *             Caso ocorra alguma exceção na inclusão.
	 */
	T incluir(T objeto) throws WalmartException;

	/**
	 * Método para excluir um objeto.
	 * 
	 * @param chave
	 *            A chave da entidade.
	 * @throws WalmartException
	 *             Caso ocorra alguma exceção na exclusão.
	 */
	void excluir(Serializable chave) throws WalmartException;

	/**
	 * Método para alterar um objeto.
	 * 
	 * @param objeto
	 *            o objeto a ser alterado.
	 * @throws WalmartException
	 *             Caso ocorra alguma exceção na alteração.
	 */
	void alterar(T objeto) throws WalmartException;

	/**
	 * Método para obter a lista padrão de uma entidade.
	 * 
	 * @return lista de objetos encontrados na consulta padrão da entidade
	 * @throws WalmartException
	 *             Caso ocorra alguma exceção na listagem.
	 */
	List<T> listar() throws WalmartException;

	/**
	 * Método para localizar um único objeto.
	 * 
	 * @param chave
	 *            A chave da entidade.
	 * @return A entidade encontrada.
	 * @throws WalmartException
	 *             Caso ocorra alguma exceção na consulta.
	 */
	T obter(Serializable chave) throws WalmartException;

}
