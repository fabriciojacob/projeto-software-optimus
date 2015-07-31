package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TbTipoProd")
public class TipoProduto implements Serializable {

	private static final long serialVersionUID = -6822091315494484402L;
	
	@Id
	@GeneratedValue
	private Long idTipoProd;
	
	private String descricao;
	
	@OneToMany(mappedBy = "tipoProduto")
	private List<CodTabelaGov> codTabelaGovList;

	public Long getIdTipoProd() {
		return idTipoProd;
	}

	public void setIdTipoProd(Long idTipoProd) {
		this.idTipoProd = idTipoProd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CodTabelaGov> getCodTabelaGovList() {
		return codTabelaGovList;
	}

	public void setCodTabelaGovList(List<CodTabelaGov> codTabelaGovList) {
		this.codTabelaGovList = codTabelaGovList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTipoProd == null) ? 0 : idTipoProd.hashCode());
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
		TipoProduto other = (TipoProduto) obj;
		if (idTipoProd == null) {
			if (other.idTipoProd != null)
				return false;
		} else if (!idTipoProd.equals(other.idTipoProd))
			return false;
		return true;
	}
}
