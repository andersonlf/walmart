/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.dto.RotaEntrega;

/**
 * Serviço EJB responsável pelas operação de cálculo do menor caminho. 
 * 
 * @author andersonlf@gmail.com
 */
@Stateless
@Local(ILogistica.class)
public class LogisticaEjb implements ILogistica {

	@PersistenceContext(unitName = "emWalmart")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * @see br.com.walmart.ejb.ILogistica#calcularMenorCaminho(br.com.walmart.dto.InformacaoEntrega)
	 */
	@Override
	public RotaEntrega calcularMenorCaminho(ParametrosEntrega dto) {
		return null;
	}
	
}
