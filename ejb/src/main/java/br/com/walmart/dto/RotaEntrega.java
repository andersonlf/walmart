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
public class RotaEntrega extends WalmartDto {

	private static final long serialVersionUID = 1L;

	private List<String> rota = new ArrayList<String>();

	private double distanciaRota = 0;

	private double autonomia = 0;

	private double valor = 0;

	/**
	 * Método JavaBean.
	 * 
	 * @return O rota.
	 */
	public List<String> getRota() {
		return rota;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param rota
	 *            O novo rota.
	 */
	public void setRota(List<String> rota) {
		this.rota = rota;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O distanciaRota.
	 */
	public double getDistanciaRota() {
		return distanciaRota;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param distanciaRota
	 *            O novo distanciaRota.
	 */
	public void setDistanciaRota(double distanciaRota) {
		this.distanciaRota = distanciaRota;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O autonomia.
	 */
	public double getAutonomia() {
		return autonomia;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param autonomia
	 *            O novo autonomia.
	 */
	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O valor.
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param valor
	 *            O novo valor.
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = rota.size() - 1; i >= 0 ; i--) {
			sb.append(rota.get(i));
			sb.append(" ");
		}
		sb.append(getCustoRota());
		return sb.toString();
	}

	/**
	 * Calcula o custo da rota.
	 * 
	 * @return Retorna o valor do custo da rota. 
	 */
	public Double getCustoRota() {
		return distanciaRota == 0 ? 0 : (distanciaRota / autonomia) * valor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(autonomia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(distanciaRota);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rota == null) ? 0 : rota.hashCode());
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (Double.doubleToLongBits(autonomia) != Double
				.doubleToLongBits(other.autonomia))
			return false;
		if (Double.doubleToLongBits(distanciaRota) != Double
				.doubleToLongBits(other.distanciaRota))
			return false;
		if (rota == null) {
			if (other.rota != null)
				return false;
		} else if (!rota.equals(other.rota))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

}
