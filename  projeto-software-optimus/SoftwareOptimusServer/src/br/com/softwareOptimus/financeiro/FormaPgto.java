package br.com.softwareOptimus.financeiro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbFormPgto")
public class FormaPgto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1303073833107653750L;
	
	@Id
	@GeneratedValue
	private Long idFormaPg;
	
	private String descricao;
	
	private TipoFormaPgto tipoFormaPgto;

	public Long getIdFormaPg() {
		return idFormaPg;
	}

	public void setIdFormaPg(Long idFormaPg) {
		this.idFormaPg = idFormaPg;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFormaPgto getTipoFormaPgto() {
		return tipoFormaPgto;
	}

	public void setTipoFormaPgto(TipoFormaPgto tipoFormaPgto) {
		this.tipoFormaPgto = tipoFormaPgto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFormaPg == null) ? 0 : idFormaPg.hashCode());
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
		FormaPgto other = (FormaPgto) obj;
		if (idFormaPg == null) {
			if (other.idFormaPg != null)
				return false;
		} else if (!idFormaPg.equals(other.idFormaPg))
			return false;
		return true;
	}
	
}
