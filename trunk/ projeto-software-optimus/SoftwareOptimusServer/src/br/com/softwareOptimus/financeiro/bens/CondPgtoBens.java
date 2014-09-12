package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.financeiro.CondPgto;
import br.com.softwareOptimus.financeiro.RN.CondPgtoRN;
import br.com.softwareOptimus.util.Geral;

@ManagedBean (name ="condPgtoBens")
@ViewScoped
public class CondPgtoBens implements Geral {

	private CondPgto condPgto;
	private CondPgtoRN condRN;
	private List<CondPgto> lista = new ArrayList<>();
	private Long id;
	private boolean btSalvar, btExcluir, btEditar, btNovo;
	
	public CondPgtoBens(){
		this.btNovo = false;
		this.btEditar = true;
		this.btSalvar = true;
		this.btExcluir = true;
	}

	@Override
	public void salvar() {
		this.condRN = new CondPgtoRN();
		try {
			this.condRN.salvar(condPgto);
			msgAcerto("Registro salvo com sucesso ");
			this.btEditar = false;
			this.btExcluir = false;
		} catch (Exception e) {
			msgErro("Problemas ao salvar a condição de pgto ", e);
		}

	}

	@Override
	public void selecionar() {
		this.condRN = new CondPgtoRN();
		try {
			this.condPgto = this.condRN.selecionar(id);
			this.btEditar = false;
			this.btEditar = false;
			this.btExcluir = false;
		} catch (Exception e) {
			msgErro("Problemas ao selecionar ", e);
		}

	}

	@Override
	public void editar() {
		this.condRN = new CondPgtoRN();
		try{
			this.condRN.editar(condPgto);
			msgAcerto("Registro editado com sucesso ");
		}catch (Exception e){
			msgErro("Problemas na edição ", e);
		}

	}

	@Override
	public void pesquisar() {
		this.condRN = new CondPgtoRN();
		try{
			this.lista = this.condRN.listar();
		}catch (Exception e){
			msgErro("Problemas na listagem ", e);
		}
	}

	@Override
	public void novo() {
		this.condPgto = new CondPgto();
		this.btEditar = true;
		this.btExcluir = true;
		this.btSalvar = false;
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

	@Override
	public void excluir() {
		this.condRN = new CondPgtoRN();
		try{
			this.condRN.remover(condPgto);
		}catch (Exception e){
			msgErro("Problemas ao excluir o registro ", e);
		}

	}

	public CondPgto getCondPgto() {
		return condPgto;
	}

	public void setCondPgto(CondPgto condPgto) {
		this.condPgto = condPgto;
	}

	public CondPgtoRN getCondRN() {
		return condRN;
	}

	public void setCondRN(CondPgtoRN condRN) {
		this.condRN = condRN;
	}

	public List<CondPgto> getLista() {
		return lista;
	}

	public void setLista(List<CondPgto> lista) {
		this.lista = lista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(boolean btSalvar) {
		this.btSalvar = btSalvar;
	}

	public boolean isBtExcluir() {
		return btExcluir;
	}

	public void setBtExcluir(boolean btExcluir) {
		this.btExcluir = btExcluir;
	}

	public boolean isBtEditar() {
		return btEditar;
	}

	public void setBtEditar(boolean btEditar) {
		this.btEditar = btEditar;
	}

	public boolean isBtNovo() {
		return btNovo;
	}

	public void setBtNovo(boolean btNovo) {
		this.btNovo = btNovo;
	}
	
}
