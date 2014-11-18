/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto que representa o menor caminho de uma rota de entrega.
 * 
 * @author andersonlf@gmail.com
 */
public class RotaEntrega {
	
	private List<String> rota = new ArrayList<String>();
	
	private double custoRota = 0;
	
	/**
	 * Método JavaBean.
	 * @return O rota.
	 */
	public List<String> getRota() {
		return rota;
	}

	/**
	 * Método JavaBean.
	 * @param rota O novo rota.
	 */
	public void setRota(List<String> rota) {
		this.rota = rota;
	}

	/**
	 * Método JavaBean.
	 * @return O custoRota.
	 */
	public double getCustoRota() {
		return custoRota;
	}

	/**
	 * Método JavaBean.
	 * @param custoRota O novo custoRota.
	 */
	public void setCustoRota(double custoRota) {
		this.custoRota = custoRota;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rota [rota=" + rota + ", custoRota=" + custoRota + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(custoRota);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rota == null) ? 0 : rota.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
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
		RotaEntrega other = (RotaEntrega) obj;
		if (Double.doubleToLongBits(custoRota) != Double
				.doubleToLongBits(other.custoRota))
			return false;
		if (rota == null) {
			if (other.rota != null)
				return false;
		} else if (!rota.equals(other.rota))
			return false;
		return true;
	}
	
}
