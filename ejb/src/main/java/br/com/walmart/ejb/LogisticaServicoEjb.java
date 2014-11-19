/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.walmart.dto.ParametrosEntrega;
import br.com.walmart.dto.RotaEntrega;
import br.com.walmart.entidades.Malha;
import br.com.walmart.exceptions.WalmartException;
import br.com.walmart.grafos.CalculadorMenorCaminho;
import br.com.walmart.processador.ProcessadorMalhaLogistica;

/**
 * Serviço EJB responsável pelas operação de cálculo do menor caminho.
 * 
 * @author andersonlf@gmail.com
 */
@Singleton
@Startup
@Local(ILogisticaServico.class)
public class LogisticaServicoEjb extends WalmartServicoAbstract implements ILogisticaServico {
	
	private Malha malhaUnica;
	
	@EJB
	private IMalhaCrudServico malhaServico;
	
	@PostConstruct
	private void carregarMalhas() {
		try {
			List<Malha> malhas = malhaServico.listar();
			if (malhas.isEmpty()) {
				getLogger().warn("Nenhuma malha foi carregada!");
			} else {
				malhaUnica = ProcessadorMalhaLogistica.processar(malhas);
			}
		} catch (WalmartException e) {
			getLogger().error(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.walmart.ejb.ILogisticaServico#calcularMenorCaminho(br.com.walmart.dto
	 * .InformacaoEntrega)
	 */
	@Override
	public RotaEntrega calcularRotaMenorCusto(ParametrosEntrega dto) throws WalmartException {
		return CalculadorMenorCaminho.calcularMenorCaminho(malhaUnica, dto);
	}

}
