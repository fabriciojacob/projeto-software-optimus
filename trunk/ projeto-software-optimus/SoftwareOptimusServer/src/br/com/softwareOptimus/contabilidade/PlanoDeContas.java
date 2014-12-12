package br.com.softwareOptimus.contabilidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Pessoa;


@Entity
@Table(name="tbPlanodeContas")
public class PlanoDeContas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -576648292350310158L;

	@Id
	@GeneratedValue
	private Long idPlaContas;
	
	private String redutor;
	
	private String descricao;
	
	private String grupo;
	
	private String classificacao;
	
	@OneToMany
	@JoinColumn(name = "empresa", nullable = false, foreignKey = @ForeignKey(name = "fk_tbPessoa4"))
	private Collection<Pessoa> empresa;
	
	//Analitica e Sintetica
	private TipoElemBas anaSin;
	
	//@ManyToMany
	//private Collection<PlanoDeContasRef> planoRef;
	
	private TipoConta tipoConta;
	
	@Temporal(TemporalType.DATE)
	private Calendar datInclusao;

	public Calendar getDatInclusao() {
		return datInclusao;
	}

	public void setDatInclusao(Calendar datInclusao) {
		this.datInclusao = datInclusao;
	}

	public Long getIdPlaContas() {
		return idPlaContas;
	}

	public void setIdPlaContas(Long idPlaContas) {
		this.idPlaContas = idPlaContas;
	}

	public String getRedutor() {
		return redutor;
	}

	public void setRedutor(String redutor) {
		this.redutor = redutor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public TipoElemBas getAnaSin() {
		return anaSin;
	}

	public void setAnaSin(TipoElemBas anaSin) {
		this.anaSin = anaSin;
	}

	public Collection<Pessoa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Collection<Pessoa> empresa) {
		this.empresa = empresa;
	}

	//public Collection<PlanoDeContasRef> getPlanoRef() {
	//	return planoRef;
	//}

	//public void setPlanoRef(Collection<PlanoDeContasRef> planoRef) {
	//	this.planoRef = planoRef;
	//}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPlaContas == null) ? 0 : idPlaContas.hashCode());
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
		PlanoDeContas other = (PlanoDeContas) obj;
		if (idPlaContas == null) {
			if (other.idPlaContas != null)
				return false;
		} else if (!idPlaContas.equals(other.idPlaContas))
			return false;
		return true;
	}
}
