package br.com.softwareOptimus.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbPessoaJuridica")
public class PessoaJuridica extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3931037073062799711L;
	
	private String cnpj;
	
	private String ie;
	
	private String cnae;
	
	private TipoPessoaJuridica tipoPessoaJuridica;
	
	private Integer regime;
	
	public Integer getRegime() {
		return regime;
	}
	
	public void setRegime(Integer regime) {
		this.regime = regime;
	}
	
	public TipoPessoaJuridica getTipoPessoaJuridica() {
		return tipoPessoaJuridica;
	}
	
	public void setTipoPessoaJuridica(TipoPessoaJuridica tipoPessoaJuridica) {
		this.tipoPessoaJuridica = tipoPessoaJuridica;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

}
