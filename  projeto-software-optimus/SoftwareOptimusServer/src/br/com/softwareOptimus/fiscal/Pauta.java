package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbPauta")
public class Pauta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9193639460516743770L;

	@Id
	@GeneratedValue
	private Long idPauta;

	private String descricao;

	@OneToMany(mappedBy = "pauta", cascade = CascadeType.REMOVE)
	private Collection<PautaMVA> pautaVig;

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPauta == null) ? 0 : idPauta.hashCode());
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
		Pauta other = (Pauta) obj;
		if (idPauta == null) {
			if (other.idPauta != null)
				return false;
		} else if (!idPauta.equals(other.idPauta))
			return false;
		return true;
	}

}
