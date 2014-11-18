/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que representa um ponto de entrega.
 *
 * @author andersonlf@gmail.com
 */
@Entity
@Table(name = "Ponto")
public class Ponto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPonto", unique = true, nullable = false, insertable = true)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idMalha", nullable = false, insertable = true, updatable = false)
	private Malha malha;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pontoOrigem")
	private List<Trecho> trechos = new ArrayList<Trecho>();

	/**
	 * Método JavaBean.
	 * 
	 * @return O nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param nome
	 *            O novo nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O malha.
	 */
	public Malha getMalha() {
		return malha;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param malha
	 *            O novo malha.
	 */
	public void setMalha(Malha malha) {
		this.malha = malha;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O trechos.
	 */
	public List<Trecho> getTrechos() {
		return trechos;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param trechos
	 *            O novo trechos.
	 */
	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ponto [nome=" + nome + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Ponto other = (Ponto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
