/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dao;

import java.io.Serializable;

import br.com.walmart.entidades.Malha;

/**
 * Interface das operações de CRUD para Malhas.
 *
 * @author andersonlf@gmail.com
 */
public interface IMalhaCrudDao {
	
	public void incluir(Malha malha);
	
	public Malha obter(Serializable chave);

}
