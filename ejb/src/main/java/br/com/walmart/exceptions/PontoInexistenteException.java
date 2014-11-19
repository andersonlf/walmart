/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.exceptions;

/**
 * Exceção usada para informar que um ponto não existe na malha logística.
 *
 * @author andersonlf@gmail.com
 */
public class PontoInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

    public PontoInexistenteException() {
        super();
    }

    public PontoInexistenteException(String message) {
        super(message);
    }

    public PontoInexistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public PontoInexistenteException(Throwable cause) {
        super(cause);
    }

}
