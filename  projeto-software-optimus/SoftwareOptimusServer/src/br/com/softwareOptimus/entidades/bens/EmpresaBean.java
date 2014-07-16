package br.com.softwareOptimus.entidades.bens;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.TipoLogradouro;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.entidades.RN.geral.LogradouroRN;

@ManagedBean
public class EmpresaBean {

	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Logradouro logradouro = new Logradouro();
	private String tipoSelecionado;

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

	public String getTipoSelecionado() {
		return tipoSelecionado;
	}

	public void setTipoSelecionado(String tipoSelecionado) {
		this.tipoSelecionado = tipoSelecionado;
	}

	public void salvar(Municipio municipio) {
		try {
			
			if (tipoSelecionado == TipoLogradouro.COBRANCA.toString()) {
				logradouro.setTipoLogr(TipoLogradouro.COBRANCA);
			} else if (tipoSelecionado == TipoLogradouro.ENTREGA.toString()) {
				logradouro.setTipoLogr(TipoLogradouro.ENTREGA);
			} else if (tipoSelecionado == TipoLogradouro.COMERCIAL.toString()) {
				logradouro.setTipoLogr(TipoLogradouro.COMERCIAL);
			} else {
				logradouro.setTipoLogr(TipoLogradouro.RESIDENCIAL);
			}

			EmpresaRN empresaRN = new EmpresaRN();
			LogradouroRN logrRN = new LogradouroRN();
			empresaRN.salvar(pessoaJuridica);
			logradouro.setPessoa(pessoaJuridica);
			logradouro.setMunicipio(municipio);
			logrRN.salvar(logradouro);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Empresa salva com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao do usuario "
									+ e.getMessage()));
		}
	}

}
