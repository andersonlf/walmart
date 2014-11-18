/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade que representa uma malha.
 * 
 * @author andersonlf@gmail.com
 */
@Entity
@Table(name = "Malha")
public class Malha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idMalha", unique = true, nullable = false, insertable = true)
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataHoraInclusao")
	private Date dataHoraInclusao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataHoraUltimaAtualizacao")
	private Date dataHoraUltimaAtualizacao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "malha")
	private List<Ponto> pontos = new ArrayList<Ponto>();

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
	 * @return O dataHoraInclusao.
	 */
	public Date getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param dataHoraInclusao
	 *            O novo dataHoraInclusao.
	 */
	public void setDataHoraInclusao(Date dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O dataHoraUltimaAtualizacao.
	 */
	public Date getDataHoraUltimaAtualizacao() {
		return dataHoraUltimaAtualizacao;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param dataHoraUltimaAtualizacao
	 *            O novo dataHoraUltimaAtualizacao.
	 */
	public void setDataHoraUltimaAtualizacao(Date dataHoraUltimaAtualizacao) {
		this.dataHoraUltimaAtualizacao = dataHoraUltimaAtualizacao;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @return O pontos.
	 */
	public List<Ponto> getPontos() {
		return pontos;
	}

	/**
	 * Método JavaBean.
	 * 
	 * @param pontos
	 *            O novo pontos.
	 */
	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Malha [nome=" + nome + ", dataHoraInclusao=" + dataHoraInclusao
				+ ", dataHoraUltimaAtualizacao=" + dataHoraUltimaAtualizacao
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataHoraInclusao == null) ? 0 : dataHoraInclusao.hashCode());
		result = prime
				* result
				+ ((dataHoraUltimaAtualizacao == null) ? 0
						: dataHoraUltimaAtualizacao.hashCode());
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
		Malha other = (Malha) obj;
		if (dataHoraInclusao == null) {
			if (other.dataHoraInclusao != null)
				return false;
		} else if (!dataHoraInclusao.equals(other.dataHoraInclusao))
			return false;
		if (dataHoraUltimaAtualizacao == null) {
			if (other.dataHoraUltimaAtualizacao != null)
				return false;
		} else if (!dataHoraUltimaAtualizacao
				.equals(other.dataHoraUltimaAtualizacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
