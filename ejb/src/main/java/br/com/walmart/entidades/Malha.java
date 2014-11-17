package br.com.walmart.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Malha")
public class Malha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idMalha", unique = true, nullable = false, insertable = true)
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "malha")
	private List<Trecho> trechos = new ArrayList<Trecho>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Trecho> getTrechos() {
		return trechos;
	}

	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}

	@Override
	public String toString() {
		return "Malha [nome=" + nome + ", trechos=" + trechos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((trechos == null) ? 0 : trechos.hashCode());
		return result;
	}

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
		if (trechos == null) {
			if (other.trechos != null)
				return false;
		} else if (!trechos.equals(other.trechos))
			return false;
		return true;
	}

}
