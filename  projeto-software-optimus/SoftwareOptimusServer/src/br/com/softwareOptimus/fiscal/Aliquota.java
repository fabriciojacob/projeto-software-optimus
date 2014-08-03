package br.com.softwareOptimus.fiscal;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbAliquota")
public class Aliquota {
	
	@Id
	@GeneratedValue
	private Long idAliq;
	
	private Double aliquota;
	
	private Double reducao;
	
	@OneToMany
	private Collection<CodigoSituacaoTributaria> cst;
	
	private TipoTrib tipo;
	
	@OneToMany(mappedBy = "aliquota")
	private Collection<Vigencia> vigencias;
	
	@OneToOne(mappedBy = "aliquota")
	private GradeTributaria grade;
	
	public GradeTributaria getGrade() {
		return grade;
	}
	
	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}
	
	public Collection<Vigencia> getVigencias() {
		return vigencias;
	}
	
	public void setVigencias(Collection<Vigencia> vigencias) {
		this.vigencias = vigencias;
	}
	
	public TipoTrib getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoTrib tipo) {
		this.tipo = tipo;
	}

	public Long getIdAliq() {
		return idAliq;
	}

	public void setIdAliq(Long idAliq) {
		this.idAliq = idAliq;
	}

	public Double getAliquota() {
		return aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}

	public Double getReducao() {
		return reducao;
	}

	public void setReducao(Double reducao) {
		this.reducao = reducao;
	}
	
	public Collection<CodigoSituacaoTributaria> getCst() {
		return cst;
	}
	
	public void setCst(Collection<CodigoSituacaoTributaria> cst) {
		this.cst = cst;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAliq == null) ? 0 : idAliq.hashCode());
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
		Aliquota other = (Aliquota) obj;
		if (idAliq == null) {
			if (other.idAliq != null)
				return false;
		} else if (!idAliq.equals(other.idAliq))
			return false;
		return true;
	}

}
