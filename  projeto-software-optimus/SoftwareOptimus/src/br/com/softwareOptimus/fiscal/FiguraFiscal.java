package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import softwareOptimus.com.produto.Produto;


@Entity
@Table(name="tbFigFiscal")
public class FiguraFiscal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6477449144228543003L;

	@Id
	@GeneratedValue
	private Long idFigura;
	
	private String descricao;
	
	@ManyToMany
	private Collection<GradeTributaria> grades;
	
	@OneToMany(mappedBy = "figura")
	private Collection<Produto> produtos;
	
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Collection<GradeTributaria> getGrades() {
		return grades;
	}
	
	public void setGrades(Collection<GradeTributaria> grades) {
		this.grades = grades;
	}
	
	public Long getIdFigura() {
		return idFigura;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setIdFigura(Long idFigura) {
		this.idFigura = idFigura;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFigura == null) ? 0 : idFigura.hashCode());
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
		FiguraFiscal other = (FiguraFiscal) obj;
		if (idFigura == null) {
			if (other.idFigura != null)
				return false;
		} else if (!idFigura.equals(other.idFigura))
			return false;
		return true;
	}
	


}
