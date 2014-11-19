/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.exceptions;

/**
 * Exceção usada para informar que uma malha logística já está cadastrada.
 *
 * @author andersonlf@gmail.com
 */
public class MalhaJaExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
    public MalhaJaExisteException() {
        super();
    }

    public MalhaJaExisteException(String message) {
        super(message);
    }

    public MalhaJaExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalhaJaExisteException(Throwable cause) {
        super(cause);
    }

}
