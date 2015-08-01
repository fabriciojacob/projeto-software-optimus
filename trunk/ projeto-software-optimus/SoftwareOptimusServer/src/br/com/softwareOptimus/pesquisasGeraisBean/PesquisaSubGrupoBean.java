package br.com.softwareOptimus.pesquisasGeraisBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.produto.RN.SubGrupoRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaSubGrupoBean")
@ViewScoped
public class PesquisaSubGrupoBean extends FacesUtil implements Serializable {

	private SubGrupoRN subGrupoRN;
	private SubGrupo subGrupo;
	private LazyDataModel<SubGrupo> subGrupoList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaSubGrupoBean(){
		subGrupoList = new LazyDataModel<SubGrupo>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<SubGrupo> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getSubGrupoRN().countSubGrupoPaginacao(getSubGrupo()));
				return getSubGrupoRN().buscaSubGrupoPaginacao(getSubGrupo(), first, pageSize);
			}
		};
	}
	
	public void selecionaSubGrupo(SubGrupo subGrupo){
		RequestContext.getCurrentInstance().closeDialog(subGrupo);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaSubGrupo", opcoes, null);
	}

	public SubGrupoRN getSubGrupoRN() {
		if(this.subGrupoRN == null){
			this.subGrupoRN = new SubGrupoRN();
		}
		return subGrupoRN;
	}

	public void setSubGrupoRN(SubGrupoRN subGrupoRN) {
		this.subGrupoRN = subGrupoRN;
	}

	public SubGrupo getSubGrupo() {
		if(this.subGrupo == null){
			this.subGrupo = new SubGrupo();
		}
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	public LazyDataModel<SubGrupo> getSubGrupoList() {
		return subGrupoList;
	}

	public void setSubGrupoList(LazyDataModel<SubGrupo> subGrupoList) {
		this.subGrupoList = subGrupoList;
	}
}
