/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.exceptions;

/**
 *
 * @author andersonlf@gmail.com
 */
public class PontoInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param mensagem
	 */
	public PontoInexistenteException(String mensagem) {
		super(mensagem);
	}

}
