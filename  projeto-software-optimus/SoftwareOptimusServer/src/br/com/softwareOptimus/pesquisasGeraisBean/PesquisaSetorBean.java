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
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.RN.GrupoRN;
import br.com.softwareOptimus.produto.RN.SetorRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaSetorBean")
@ViewScoped
public class PesquisaSetorBean extends FacesUtil implements Serializable {

	private GrupoRN grupoRN;
	private SetorRN setorRN;
	private Grupo grupo;
	private Setor setor;
	private List<Grupo> grupoList;
	private LazyDataModel<Setor> setorList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaSetorBean(){
		setorList = new LazyDataModel<Setor>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<Setor> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getSetorRN().countSetorPaginacao(getSetor(), getGrupo()));
				return getSetorRN().buscaSetorPaginacao(getSetor(), getGrupo(), first, pageSize);
			}
		};
	}
	
	public void selecionaSetor(Setor setor){
		RequestContext.getCurrentInstance().closeDialog(setor);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaSetor", opcoes, null);
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

	public SetorRN getSetorRN() {
		if(this.setorRN == null){
			this.setorRN = new SetorRN();
		}
		return setorRN;
	}

	public void setSetorRN(SetorRN setorRN) {
		this.setorRN = setorRN;
	}

	public List<Grupo> getGrupoList() {
		if(this.grupoList == null){
			this.grupoList = new ArrayList<Grupo>();
			this.grupoList.addAll(this.getGrupoRN().listar());
		}
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}

	public LazyDataModel<Setor> getSetorList() {
		return setorList;
	}

	public void setSetorList(LazyDataModel<Setor> setorList) {
		this.setorList = setorList;
	}

	public Setor getSetor() {
		if(this.setor == null){
			this.setor = new Setor();
		}
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
}
