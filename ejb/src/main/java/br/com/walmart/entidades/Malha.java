/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries(value = {
		@NamedQuery(name="findMalhaByNome", query="select m from Malha m where m.nome = :nome"),
})
public class Malha extends WalmartEntidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMalha")
	private Long id;

	@Column(name = "nome")
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

	/**
	 * Método para responder se a malha contém um ponto especificado.
	 * Um ponto pertence a malha se ele está entre seus pontos.
	 * 
	 * @param ponto O ponto a ser verificado.
	 * @return <code>true</code> se o ponto pertence a essa malha.
	 */
	public boolean contemPonto(Ponto ponto) {
		return getPontos().contains(ponto);
	}
	
	/**
	 * Método usado para adicionar um ponto a malha.
	 * 
	 * @param ponto O ponto a ser adicionado na malha.
	 */
	public void addPonto(Ponto ponto) {
		getPontos().add(ponto);
	}
	
	/**
	 * Método usado para obter um ponto de uma malha.
	 * @param nomePonto O nome do ponto a ser recuperado.
	 * @return Retorna o ponto ou <code>null</code> caso o ponto não exista.
	 */
	public Ponto obterPonto(String nomePonto) {
		for (Ponto ponto : getPontos()) {
			if (ponto.getNome().equals(nomePonto)) {
				return ponto;
			}
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Malha [id=" + id + ", nome=" + nome + "]";
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Malha other = (Malha) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
