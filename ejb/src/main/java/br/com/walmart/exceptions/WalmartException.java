/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.exceptions;

/**
 * Super classe para todas as exceções do projeto.
 *
 * @author andersonlf@gmail.com
 */
public class WalmartException extends Exception {

	private static final long serialVersionUID = 1L;
	
    public WalmartException() {
        super();
    }

    public WalmartException(String message) {
        super(message);
    }

    public WalmartException(String message, Throwable cause) {
        super(message, cause);
    }

    public WalmartException(Throwable cause) {
        super(cause);
    }

}
