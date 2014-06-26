package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Pessoa;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tbComercial")
public class Comercial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6003040190425541638L;

	@Id
	@GeneratedValue
	private Long idComercial;

	@ManyToMany
	@JoinTable(name="tbVincPesEmp", 
		joinColumns=@JoinColumn(name = "pessoa"), 
		inverseJoinColumns = @JoinColumn(name = "empresa"))
	private Collection<Pessoa> entidade;

	// tabela 4.1.1
	@Column(length = 2, nullable = false, unique = false)
	private String codModelo;
	// tabela 4.1.2
	@Column(length = 2, nullable = false, unique = false)
	private String codSituacao;

	@Column(length = 3, nullable = false, unique = false)
	private String serie;

	@Column(length = 9, nullable = false, unique = false)
	private String numDoc;

	@Column(length = 44, nullable = true, unique = false)
	private String chvNfe;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, unique = false)
	private Calendar datEmiss;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, unique = false)
	private Calendar datEntr;
	
	private IndOper ind_Oper;
	//obrigado apenas para nota de serviço
	private IndOperServ ind_OperServ;
	
	private IndEmit ind_Emit;

	private Double ValDoc;

	// campo 13 - c100
	private Long indPgto;

	private Double valDesc;

	private Double valMerc;

	// campo 17 - c100
	private Long indFrete;

	private Double valFrete;

	private Double valDespAcessorio;

	private Double valBcIcms;

	private Double valIcms;

	private Double valBcIcmsSt;

	private Double valIcmsSt;

	private Double valIpi;

	private Double valPis;

	private Double valCofins;

	private Double valPisSt;

	private Double valCofinsSt;
	
	@OneToMany(mappedBy = "Comercial")
	private Collection<ComercialFiscais> idComFiscais;
	
	@OneToMany(mappedBy = "Comercial")
	private Collection<ComercialInfComp> idComInfComp;	
	
	@OneToMany(mappedBy = "Comercial")
	private Collection<ComercialItens> idComItens;	
	
	public Collection<Pessoa> getEntidade() {
		return entidade;
	}

	public void setEntidade(Collection<Pessoa> entidade) {
		this.entidade = entidade;
	}

	public IndOper getInd_Oper() {
		return ind_Oper;
	}

	public void setInd_Oper(IndOper ind_Oper) {
		this.ind_Oper = ind_Oper;
	}

	public IndOperServ getInd_OperServ() {
		return ind_OperServ;
	}

	public void setInd_OperServ(IndOperServ ind_OperServ) {
		this.ind_OperServ = ind_OperServ;
	}

	public Long getIdComercial() {
		return idComercial;
	}

	public void setIdComercial(Long idComercial) {
		this.idComercial = idComercial;
	}

	public IndEmit getInd_Emit() {
		return ind_Emit;
	}

	public void setInd_Emit(IndEmit ind_Emit) {
		this.ind_Emit = ind_Emit;
	}

		public String getCodModelo() {
		return codModelo;
	}

	public void setCodModelo(String codModelo) {
		this.codModelo = codModelo;
	}

	public String getCodSituacao() {
		return codSituacao;
	}

	public void setCodSituacao(String codSituacao) {
		this.codSituacao = codSituacao;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getChvNfe() {
		return chvNfe;
	}

	public void setChvNfe(String chvNfe) {
		this.chvNfe = chvNfe;
	}

	public Calendar getDatEmiss() {
		return datEmiss;
	}

	public void setDatEmiss(Calendar datEmiss) {
		this.datEmiss = datEmiss;
	}

	public Calendar getDatEntr() {
		return datEntr;
	}

	public void setDatEntr(Calendar datEntr) {
		this.datEntr = datEntr;
	}

	public Double getValDoc() {
		return ValDoc;
	}

	public void setValDoc(Double valDoc) {
		ValDoc = valDoc;
	}

	public Long getIndPgto() {
		return indPgto;
	}

	public void setIndPgto(Long indPgto) {
		this.indPgto = indPgto;
	}

	public Double getValDesc() {
		return valDesc;
	}

	public void setValDesc(Double valDesc) {
		this.valDesc = valDesc;
	}
	
	public Double getValDespAcessorio() {
		return valDespAcessorio;
	}

	public void setValDespAcessorio(Double valDespAcessorio) {
		this.valDespAcessorio = valDespAcessorio;
	}

	public Double getValMerc() {
		return valMerc;
	}

	public void setValMerc(Double valMerc) {
		this.valMerc = valMerc;
	}

	public Long getIndFrete() {
		return indFrete;
	}

	public void setIndFrete(Long indFrete) {
		this.indFrete = indFrete;
	}

	public Double getValFrete() {
		return valFrete;
	}

	public void setValFrete(Double valFrete) {
		this.valFrete = valFrete;
	}

	public Double getValBcIcms() {
		return valBcIcms;
	}

	public void setValBcIcms(Double valBcIcms) {
		this.valBcIcms = valBcIcms;
	}

	public Double getValIcms() {
		return valIcms;
	}

	public void setValIcms(Double valIcms) {
		this.valIcms = valIcms;
	}

	public Double getValBcIcmsSt() {
		return valBcIcmsSt;
	}

	public void setValBcIcmsSt(Double valBcIcmsSt) {
		this.valBcIcmsSt = valBcIcmsSt;
	}

	public Double getValIcmsSt() {
		return valIcmsSt;
	}

	public void setValIcmsSt(Double valIcmsSt) {
		this.valIcmsSt = valIcmsSt;
	}

	public Double getValIpi() {
		return valIpi;
	}

	public void setValIpi(Double valIpi) {
		this.valIpi = valIpi;
	}

	public Double getValPis() {
		return valPis;
	}

	public void setValPis(Double valPis) {
		this.valPis = valPis;
	}

	public Double getValCofins() {
		return valCofins;
	}

	public void setValCofins(Double valCofins) {
		this.valCofins = valCofins;
	}

	public Double getValPisSt() {
		return valPisSt;
	}

	public void setValPisSt(Double valPisSt) {
		this.valPisSt = valPisSt;
	}

	public Double getValCofinsSt() {
		return valCofinsSt;
	}

	public void setValCofinsSt(Double valCofinsSt) {
		this.valCofinsSt = valCofinsSt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComercial == null) ? 0 : idComercial.hashCode());
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
		Comercial other = (Comercial) obj;
		if (idComercial == null) {
			if (other.idComercial != null)
				return false;
		} else if (!idComercial.equals(other.idComercial))
			return false;
		return true;
	}

}
