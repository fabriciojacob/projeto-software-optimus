package br.com.softwareOptimus.producao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tbFases")
public class Fases implements Serializable{

	/**
	 * fazer setorização e almoxarifado
	 */
	private static final long serialVersionUID = 798000501520244965L;
	
	@Id
	@GeneratedValue
	private Long idFases;
	
	private String descricao;
	
	private TipoFase tipoFase;
	
	private TipoPeso tipoPeso;
	
	private boolean geraEstoque;
	
	@OneToMany
	private Collection<Fases> fases;
	
	private Double custoMO;
	
	private Double custoMQ;
	
	private Double custoGR;

	public Long getIdFases() {
		return idFases;
	}

	public void setIdFases(Long idFases) {
		this.idFases = idFases;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFase getTipoFase() {
		return tipoFase;
	}

	public void setTipoFase(TipoFase tipoFase) {
		this.tipoFase = tipoFase;
	}

	public TipoPeso getTipoPeso() {
		return tipoPeso;
	}

	public void setTipoPeso(TipoPeso tipoPeso) {
		this.tipoPeso = tipoPeso;
	}

	public boolean isGeraEstoque() {
		return geraEstoque;
	}

	public void setGeraEstoque(boolean geraEstoque) {
		this.geraEstoque = geraEstoque;
	}

	public Collection<Fases> getFases() {
		return fases;
	}

	public void setFases(Collection<Fases> fases) {
		this.fases = fases;
	}

	public Double getCustoMO() {
		return custoMO;
	}

	public void setCustoMO(Double custoMO) {
		this.custoMO = custoMO;
	}

	public Double getCustoMQ() {
		return custoMQ;
	}

	public void setCustoMQ(Double custoMQ) {
		this.custoMQ = custoMQ;
	}

	public Double getCustoGR() {
		return custoGR;
	}

	public void setCustoGR(Double custoGR) {
		this.custoGR = custoGR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFases == null) ? 0 : idFases.hashCode());
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
		Fases other = (Fases) obj;
		if (idFases == null) {
			if (other.idFases != null)
				return false;
		} else if (!idFases.equals(other.idFases))
			return false;
		return true;
	}

}
