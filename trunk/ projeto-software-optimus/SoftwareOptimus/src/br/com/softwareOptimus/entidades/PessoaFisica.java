package br.com.softwareOptimus.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbPessoaFisica")
public class PessoaFisica extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5222698061336157190L;
	
	private String cpf;
	
	private String rg;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
