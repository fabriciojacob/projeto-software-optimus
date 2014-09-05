package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.RN.CaixaRN;

@ManagedBean
@ViewScoped
public class CaixaBean {

	private CaixaRN caixaRN;
	private Caixa caixa;
	private List<Caixa> listaCaixa = new ArrayList<>();
	private String descricao;
	private Long id;
	private boolean btNovo = false, btEditar = true, btExcluir = true,
			btCancelar = true, btSalvar = true;

	public CaixaBean() {
		this.caixaRN = new CaixaRN();
		this.caixa = new Caixa();
	}

	public void novo() {
		this.caixa = new Caixa();
		this.btSalvar = false;
		this.btCancelar = false;
		this.btEditar = true;
		this.btExcluir = true;
		this.btEditar = true;
	}

	public void salvar() {
		try {
			if (!this.caixa.getDescricao().isEmpty()) {
				this.caixaRN = new CaixaRN();
				this.caixaRN.salvar(caixa);
				msgAcerto("Caixa salvo com sucesso!!");
				this.btEditar = false;
				this.btExcluir = false;
				this.btSalvar = true;
			} else {
				msgErro("Caixa sem descrição", null);
			}
		} catch (Exception e) {
			msgErro("Problemas ao salvar o caixa ", e);
		}
	}

	public void editar() {
		try {
			this.caixaRN = new CaixaRN();
			this.caixaRN.editar(caixa);
			msgAcerto("Caixa editado com sucesso!!!");
		} catch (Exception e) {
			msgErro("Problemas ao editar o caixa ", e);
		}
	}

	public void excluir() {
		try {
			this.caixaRN = new CaixaRN();
			this.caixaRN.excluir(caixa);
			msgAcerto("Caixa excluido com sucesso");
		} catch (Exception e) {
			msgErro("Problemas ao excluir o caixa ", e);
		}
	}

	public void pesquisar() {
		try {
			this.caixaRN = new CaixaRN();
			if (this.listaCaixa != null) {
				this.listaCaixa.clear();
			}
			this.listaCaixa = this.caixaRN.pesquisaCaixa(descricao);
			this.btEditar = false;
			this.btSalvar = true;
			this.btExcluir = false;
		} catch (Exception e) {
			msgErro("Problemas ao pesquisar os caixas ", e);
		}
	}

	public void selecionar() {
		try {
			this.caixaRN = new CaixaRN();
			this.caixa = this.caixaRN.pesquisaID(id);
		} catch (Exception e) {
			msgErro("Problemas ao selecionar o caixa ", e);
		}
	}

	public CaixaRN getCaixaRN() {
		return caixaRN;
	}

	public void setCaixaRN(CaixaRN caixaRN) {
		this.caixaRN = caixaRN;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<Caixa> getListaCaixa() {
		return listaCaixa;
	}

	public void setListaCaixa(List<Caixa> listaCaixa) {
		this.listaCaixa = listaCaixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isBtNovo() {
		return btNovo;
	}

	public void setBtNovo(boolean btNovo) {
		this.btNovo = btNovo;
	}

	public boolean isBtEditar() {
		return btEditar;
	}

	public void setBtEditar(boolean btEditar) {
		this.btEditar = btEditar;
	}

	public boolean isBtExcluir() {
		return btExcluir;
	}

	public void setBtExcluir(boolean btExcluir) {
		this.btExcluir = btExcluir;
	}

	public boolean isBtCancelar() {
		return btCancelar;
	}

	public void setBtCancelar(boolean btCancelar) {
		this.btCancelar = btCancelar;
	}

	public boolean isBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(boolean btSalvar) {
		this.btSalvar = btSalvar;
	}

	public void msgAcerto(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
	}

	public void msgErro(String msg, Exception e) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", msg
						+ e.getMessage()));
	}

}
