package br.com.softwareOptimus.contabilidade;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbPlanoDeContaRef")
public class PlanoDeContasRef implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9208297983304987463L;

	@Id
	@GeneratedValue
	private Long idPlanContRef;
	
	private String codCtaRef;
	
	private String descricao;
	
	private String orientacao;
	
	@Temporal(TemporalType.DATE)
	private Calendar datValInicio;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataValFim;

	private TipoElemBas ElemBas;

	public Long getIdPlanContRef() {
		return idPlanContRef;
	}

	public void setIdPlanContRef(Long idPlanContRef) {
		this.idPlanContRef = idPlanContRef;
	}

	public String getCodCtaRef() {
		return codCtaRef;
	}

	public void setCodCtaRef(String codCtaRef) {
		this.codCtaRef = codCtaRef;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public Calendar getDatValInicio() {
		return datValInicio;
	}

	public void setDatValInicio(Calendar datValInicio) {
		this.datValInicio = datValInicio;
	}

	public Calendar getDataValFim() {
		return dataValFim;
	}

	public void setDataValFim(Calendar dataValFim) {
		this.dataValFim = dataValFim;
	}

	public TipoElemBas getElemBas() {
		return ElemBas;
	}

	public void setElemBas(TipoElemBas elemBas) {
		ElemBas = elemBas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPlanContRef == null) ? 0 : idPlanContRef.hashCode());
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
		PlanoDeContasRef other = (PlanoDeContasRef) obj;
		if (idPlanContRef == null) {
			if (other.idPlanContRef != null)
				return false;
		} else if (!idPlanContRef.equals(other.idPlanContRef))
			return false;
		return true;
	}

}
