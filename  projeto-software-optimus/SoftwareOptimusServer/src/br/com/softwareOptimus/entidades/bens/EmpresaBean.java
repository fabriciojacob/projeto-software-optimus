package br.com.softwareOptimus.entidades.bens;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.entidades.RN.geral.LogradouroRN;

@ManagedBean
@ViewScoped
public class EmpresaBean {
	
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Logradouro logradouro = new Logradouro();
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public Logradouro getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	
	public void salvar(){
		try{
			EmpresaRN empresaRN = new EmpresaRN();
			LogradouroRN logrRN = new LogradouroRN();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	

}
