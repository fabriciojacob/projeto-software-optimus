package br.com.softwareOptimus.pesquisasGeraisBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.produto.RN.GrupoRN;
import br.com.softwareOptimus.produto.RN.SubGrupoRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaGrupoBean")
@ViewScoped
public class PesquisaGrupoBean extends FacesUtil implements Serializable {

	private GrupoRN grupoRN;
	private SubGrupoRN subGrupoRN;
	private Grupo grupo;
	private SubGrupo subGrupo;
	private List<SubGrupo> subGrupoList;
	private LazyDataModel<Grupo> grupoList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaGrupoBean(){
		grupoList = new LazyDataModel<Grupo>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<Grupo> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getGrupoRN().countGrupoPaginacao(getGrupo(), getSubGrupo()));
				return getGrupoRN().buscaGrupoPaginacao(getGrupo(), getSubGrupo(), first, pageSize);
			}
		};
	}
	
	public void selecionaGrupo(Grupo grupo){
		RequestContext.getCurrentInstance().closeDialog(grupo);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaGrupo", opcoes, null);
	}

	public GrupoRN getGrupoRN() {
		if(this.grupoRN == null){
			this.grupoRN = new GrupoRN();
		}
		return grupoRN;
	}

	public void setGrupoRN(GrupoRN grupoRN) {
		this.grupoRN = grupoRN;
	}

	public Grupo getGrupo() {
		if(this.grupo == null){
			this.grupo = new Grupo();
		}
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public LazyDataModel<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(LazyDataModel<Grupo> grupoList) {
		this.grupoList = grupoList;
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

	public SubGrupoRN getSubGrupoRN() {
		if(this.subGrupoRN == null){
			this.subGrupoRN = new SubGrupoRN();
		}
		return subGrupoRN;
	}

	public void setSubGrupoRN(SubGrupoRN subGrupoRN) {
		this.subGrupoRN = subGrupoRN;
	}

	public List<SubGrupo> getSubGrupoList() {
		if(this.subGrupoList == null){
			this.subGrupoList = new ArrayList<SubGrupo>();
			this.subGrupoList.addAll(this.getSubGrupoRN().listar());
		}
		return subGrupoList;
	}

	public void setSubGrupoList(List<SubGrupo> subGrupoList) {
		this.subGrupoList = subGrupoList;
	}
}
