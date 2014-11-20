/*
 * Desenvolvido por Anderson Lobo Feitosa, 2014
 */
package br.com.walmart.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Ponto extends WalmartEntidade {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPonto")
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idMalha")
	private Malha malha;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pontoOrigem")
	private List<Trecho> trechos = new ArrayList<Trecho>();

	/**
	 * Método JavaBean.
	 * @return O id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método JavaBean.
	 * @param id O novo id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método JavaBean.
	 * @return O nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método JavaBean.
	 * @param nome O novo nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método JavaBean.
	 * @return O malha.
	 */
	public Malha getMalha() {
		return malha;
	}

	/**
	 * Método JavaBean.
	 * @param malha O novo malha.
	 */
	public void setMalha(Malha malha) {
		this.malha = malha;
	}

	/**
	 * Método JavaBean.
	 * @return O trechos.
	 */
	public List<Trecho> getTrechos() {
		return trechos;
	}

	/**
	 * Método JavaBean.
	 * @param trechos O novo trechos.
	 */
	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}
	
	/**
	 * Método usado para verificar se um ponto contém um trecho especificado.
	 * O trecho especificado deve obrigatoriamente ter mesma origem e mesmo destino.
	 * 
	 * @param trecho O trecho a ser verificado.
	 * @return <code>true</code> se o trecho está presente no ponto.
	 */
	public boolean contemTrecho(Trecho trecho) {
		return getTrechos().contains(trecho);
	}

	/**
	 * Método usado para adicionar um trecho ao ponto.
	 * 
	 * @param trecho O trecho a ser adicionado.
	 */
	public void addTrecho(Trecho trecho) {
		getTrechos().add(trecho);
	}

	/**
	 * Método usado para recuperar um trecho com o destio especificado.
	 * 
	 * @param destino O nome do destino.
	 * @return O trecho com destino especificado ou <code>null</code> caso não exista.
	 */
	public Trecho obterTrecho(String destino) {
		for (Trecho trecho : trechos) {
			if (trecho.getPontoDestino().getNome().equals(destino)) {
				return trecho;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ponto [id=" + id + ", nome=" + nome + "]";
	}

	/* (non-Javadoc)
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
