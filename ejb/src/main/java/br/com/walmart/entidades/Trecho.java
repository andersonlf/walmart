/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidade que representa um trecho de uma malha. Um trecho é a ligação entre
 * dois pontos de uma malha.
 * 
 * @author andersonlf@gmail.com
 */
@Entity
@Table(name = "Trecho")
public class Trecho extends WalmartEntidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTrecho")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idPontoOrigem")
	private Ponto pontoOrigem;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idPontoDestino")
	private Ponto pontoDestino;

	@Column(name = "distancia")
	private Double distancia;

	/**
	 * Método JavaBean.
	 * 
	 * @return O id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param id
	 *            O novo id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O pontoOrigem.
	 */
	public Ponto getPontoOrigem() {
		return pontoOrigem;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param pontoOrigem
	 *            O novo pontoOrigem.
	 */
	public void setPontoOrigem(Ponto pontoOrigem) {
		this.pontoOrigem = pontoOrigem;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O pontoDestino.
	 */
	public Ponto getPontoDestino() {
		return pontoDestino;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param pontoDestino
	 *            O novo pontoDestino.
	 */
	public void setPontoDestino(Ponto pontoDestino) {
		this.pontoDestino = pontoDestino;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O distancia.
	 */
	public Double getDistancia() {
		return distancia;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param distancia
	 *            O novo distancia.
	 */
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trecho [pontoOrigem=" + pontoOrigem + ", pontoDestino="
				+ pontoDestino + ", distancia=" + distancia + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result
				+ ((pontoDestino == null) ? 0 : pontoDestino.hashCode());
		result = prime * result
				+ ((pontoOrigem == null) ? 0 : pontoOrigem.hashCode());
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
		Trecho other = (Trecho) obj;
		if (pontoDestino == null) {
			if (other.pontoDestino != null)
				return false;
		} else if (!pontoDestino.equals(other.pontoDestino))
			return false;
		if (pontoOrigem == null) {
			if (other.pontoOrigem != null)
				return false;
		} else if (!pontoOrigem.equals(other.pontoOrigem))
			return false;
		return true;
	}

}
