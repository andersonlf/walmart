/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dto;

/**
 * Objeto que representa as informções de uma entrega.
 * 
 * @author andersonlf@gmail.com
 */
public class ParametrosEntrega extends WalmartDto {
	
	private static final long serialVersionUID = 1L;

	private String origem;
	
	private String destino;

	private double autonomiaVeiculo;
	
	private double valorLitroCombustivel;

	/**
	 * Método JavaBean.
	 * @return O origem.
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * Método JavaBean.
	 * @param origem O novo origem.
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * Método JavaBean.
	 * @return O destino.
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Método JavaBean.
	 * @param destino O novo destino.
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	/**
	 * Método JavaBean.
	 * @return O autonomiaVeiculo.
	 */
	public double getAutonomiaVeiculo() {
		return autonomiaVeiculo;
	}

	/**
	 * Método JavaBean.
	 * @param autonomiaVeiculo O novo autonomiaVeiculo.
	 */
	public void setAutonomiaVeiculo(double autonomiaVeiculo) {
		this.autonomiaVeiculo = autonomiaVeiculo;
	}

	/**
	 * Método JavaBean.
	 * @return O valorLitroCombustivel.
	 */
	public double getValorLitroCombustivel() {
		return valorLitroCombustivel;
	}

	/**
	 * Método JavaBean.
	 * @param valorLitroCombustivel O novo valorLitroCombustivel.
	 */
	public void setValorLitroCombustivel(double valorLitroCombustivel) {
		this.valorLitroCombustivel = valorLitroCombustivel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParametrosEntrega [origem=" + origem + ", destino=" + destino
				+ ", autonomiaVeiculo="	+ autonomiaVeiculo + 
				", valorLitroCombustivel=" + valorLitroCombustivel + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(autonomiaVeiculo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		temp = Double.doubleToLongBits(valorLitroCombustivel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParametrosEntrega other = (ParametrosEntrega) obj;
		if (Double.doubleToLongBits(autonomiaVeiculo) != Double
				.doubleToLongBits(other.autonomiaVeiculo))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (Double.doubleToLongBits(valorLitroCombustivel) != Double
				.doubleToLongBits(other.valorLitroCombustivel))
			return false;
		return true;
	}

}
