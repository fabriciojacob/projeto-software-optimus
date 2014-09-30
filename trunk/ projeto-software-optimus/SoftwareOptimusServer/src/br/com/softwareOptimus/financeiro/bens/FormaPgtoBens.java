package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.financeiro.FormaPgto;
import br.com.softwareOptimus.financeiro.TipoFormaPgto;
import br.com.softwareOptimus.financeiro.RN.FormaPgtoRN;
import br.com.softwareOptimus.util.Geral;

@ManagedBean(name = "formaPgtoBens")
@ViewScoped
public class FormaPgtoBens implements Geral {

	private FormaPgto formaPgto;
	private String tipoPgto, descricao;
	private FormaPgtoRN formaRN = new FormaPgtoRN();
	private Long id;
	private List<FormaPgto> lista = new ArrayList<>();
	private boolean btNovo = false, btSalvar = true, btEditar = true,
			btExcluir = true;

	public FormaPgtoBens() {
		this.formaPgto = new FormaPgto();
		try {
			setLista(this.formaRN.listar(" "));
		} catch (Exception e) {
			msgErro("Não há registros de forma de pgto ", e);
		}
	}

	@Override
	public void salvar() {
		formaRN = new FormaPgtoRN();
		try {
			if (tipoPgto.equals(TipoFormaPgto.CARTAO_CREDITO.toString())) {
				this.formaPgto.setTipoFormaPgto(TipoFormaPgto.CARTAO_CREDITO);
			} else if (tipoPgto.equals(TipoFormaPgto.CARTAO_DEBITO.toString())) {
				this.formaPgto.setTipoFormaPgto(TipoFormaPgto.CARTAO_DEBITO);
			} else if (tipoPgto.equals(TipoFormaPgto.CHEQUE.toString())) {
				this.formaPgto.setTipoFormaPgto(TipoFormaPgto.CHEQUE);
			} else {
				this.formaPgto.setTipoFormaPgto(TipoFormaPgto.DINHEIRO);
			}
			formaRN.salvar(formaPgto);
			msgAcerto("Registro salvo com sucesso");
			this.btEditar = false;
			this.btExcluir = false;
		} catch (Exception e) {
			msgErro("Problemas ao salvar ", e);
		}

	}

	@Override
	public void selecionar() {
		formaRN = new FormaPgtoRN();
		try {
			this.formaPgto = this.formaRN.selecionar(id);
			this.btEditar = false;
			this.btExcluir = false;
		} catch (Exception e) {
			msgErro("Problemas ao selecionar o registro ", e);
		}

	}

	@Override
	public void editar() {
		formaRN = new FormaPgtoRN();
		try {
			formaRN.editar(formaPgto);
			msgAcerto("Registro editado com sucesso");
		} catch (Exception e) {
			msgErro("Problemas ao editar o registro ", e);
		}

	}

	@Override
	public void pesquisar() {
		formaRN = new FormaPgtoRN();
		try {
			this.lista = formaRN.listar(descricao);
			this.btEditar = false;
			this.btSalvar = true;
			this.btNovo = false;
			this.btExcluir = false;
		} catch (Exception e) {
			msgErro("Problemas ao listar os registros", e);
		}

	}

	@Override
	public void novo() {
		this.formaPgto = new FormaPgto();
		this.btSalvar = false;
		this.btNovo = true;
		this.btExcluir = true;

	}

	public FormaPgto getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(FormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}

	public String getTipoPgto() {
		return tipoPgto;
	}

	public void setTipoPgto(String tipoPgto) {
		this.tipoPgto = tipoPgto;
	}

	@Override
	public void msgAcerto(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
	}

	@Override
	public void msgErro(String msg, Exception e) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", msg
						+ e.getMessage()));
	}

	public FormaPgtoRN getFormaRN() {
		return formaRN;
	}

	public void setFormaRN(FormaPgtoRN formaRN) {
		this.formaRN = formaRN;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FormaPgto> getLista() {
		return lista;
	}

	public void setLista(List<FormaPgto> lista) {
		this.lista = lista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public void excluir() {
		this.formaRN = new FormaPgtoRN();
		try {
			this.formaRN.remover(formaPgto);
			msgAcerto("Registro excluido com sucesso ");
			this.btEditar = true;
			this.btSalvar = true;
			this.btNovo = false;
			this.btExcluir = true;
			this.formaPgto = new FormaPgto();
		} catch (Exception e) {
			msgErro("Problemas ao excluir o registro ", e);
		}

	}

	public boolean isBtNovo() {
		return btNovo;
	}

	public void setBtNovo(boolean btNovo) {
		this.btNovo = btNovo;
	}

	public boolean isBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(boolean btSalvar) {
		this.btSalvar = btSalvar;
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

}
