/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.dto.RotaEntrega;
import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.PontoInexistenteException;
import br.com.walmart.grafos.CalculadorMenorCaminho;

/**
 * Serviço EJB responsável pelas operação de cálculo do menor caminho.
 * 
 * @author andersonlf@gmail.com
 */
@Singleton
@Startup
@Local(ILogisticaServico.class)
public class LogisticaServicoEjb implements ILogisticaServico {

	private Malha malha = null;

	/*
	 * (non-Javadoc)
	 * @see br.com.walmart.ejb.ILogisticaServico#setMalha(br.com.walmart.entidades.Malha)
	 */
	@Override
	public void setMalha(Malha malha) {
		this.malha = malha;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.walmart.ejb.ILogisticaServico#calcularMenorCaminho(br.com.walmart.dto
	 * .InformacaoEntrega)
	 */
	@Override
	public RotaEntrega calcularRotaMenorCusto(ParametrosEntrega dto) throws PontoInexistenteException {
		return CalculadorMenorCaminho.calcularMenorCaminho(malha, dto);
	}

}
