/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import java.io.Serializable;

import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.MalhaJaExisteException;

/**
 * Interface para operações com malhas. 
 * 
 * @author andersonlf@gmail.com
 */
public interface IMalhaCrudServico {
	
	/**
	 * Método responsável por incluir uma malha.
	 * 
	 * @param malha A malha que deve ser persistida.
	 * @return <code>true</code> se a malha foi persistida com sucesso.
	 * @throws MalhaJaExisteException 
	 */
	public boolean incluir(Malha malha) throws MalhaJaExisteException;

	/**
	 * Método responsável por obter uma malha.
	 * 
	 * @param chave A chave da malha que deve ser excluída.
	 * @return A malha com a chave especificada.
	 */
	public Malha obter(Serializable chave);
	
}
