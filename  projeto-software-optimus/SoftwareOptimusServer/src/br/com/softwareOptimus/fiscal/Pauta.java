package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Collection;

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

	@OneToMany(mappedBy = "pauta")
	private Collection<PautaMVA> pautaCollection;
	
	@OneToMany(mappedBy = "pauta")
	private Collection<GradeTributariaVigencia> gradeTibutariaVigenciaCollection;

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

	public Collection<PautaMVA> getPautaCollection() {
		return pautaCollection;
	}

	public void setPautaCollection(Collection<PautaMVA> pautaCollection) {
		this.pautaCollection = pautaCollection;
	}

	public Collection<GradeTributariaVigencia> getGradeTibutariaVigenciaCollection() {
		return gradeTibutariaVigenciaCollection;
	}

	public void setGradeTibutariaVigenciaCollection(
			Collection<GradeTributariaVigencia> gradeTibutariaVigenciaCollection) {
		this.gradeTibutariaVigenciaCollection = gradeTibutariaVigenciaCollection;
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
