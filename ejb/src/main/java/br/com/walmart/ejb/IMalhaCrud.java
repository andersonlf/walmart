/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import java.io.Serializable;
import java.util.List;

import br.com.walmart.entidades.Malha;

/**
 * Interface para operações com malhas. 
 * 
 * @author andersonlf@gmail.com
 */
public interface IMalhaCrud {
	
	/**
	 * Método responsável por incluir uma malha.
	 * 
	 * @param malha A malha que deve ser persistida.
	 * @return <code>true</code> se a malha foi persistida com sucesso.
	 */
	public boolean incluir(Malha malha);

	/**
	 * Método responsável por atualizar uma malha.
	 * 
	 * @param malha A malha que deve ser atualizada.
	 * @return <code>true</code> se a malha foi atualizada com sucesso.
	 */
	public boolean atualizar(Malha malha);
	
	/**
	 * Método responsável por exluir uma malha.
	 * 
	 * @param chave A chave da malha que deve ser excluída.
	 * @return <code>true</code> se a malha foi excluída com sucesso.
	 */
	public boolean exluir(Serializable chave);
	
	/**
	 * Método responsável por obter uma malha.
	 * 
	 * @param chave A chave da malha que deve ser excluída.
	 * @return A malha com a chave especificada.
	 */
	public Malha obter(Serializable chave);
	
	/**
	 * Método responsável por listar todas as malhas persistidas.
	 * 
	 * @return Uma lista com todas as malhas persistidas.
	 */
	public List<Malha> listar();
	
}
