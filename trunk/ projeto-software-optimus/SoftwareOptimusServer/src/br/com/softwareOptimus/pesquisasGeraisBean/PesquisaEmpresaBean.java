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

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaEmpresaBean")
@ViewScoped
public class PesquisaEmpresaBean extends FacesUtil implements Serializable {

	private Pessoa empresa;
	private LazyDataModel<Pessoa> empresaList;
	private EmpresaRN empRN;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaEmpresaBean(){
		empresaList = new LazyDataModel<Pessoa>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<Pessoa> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getEmpRN().countEmpresaPaginacao(getEmpresa()));
				return getEmpRN().buscaEmpresaPaginacao(getEmpresa(), first, pageSize);
			}
		};
	}
	
	public void selecionaEmpresa(Pessoa empresa){
		RequestContext.getCurrentInstance().closeDialog(empresa);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaEmpresa", opcoes, null);
	}

	public Pessoa getEmpresa() {
		if(this.empresa == null){
			this.empresa = new Pessoa();
		}
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

	public LazyDataModel<Pessoa> getEmpresaList() {
		return empresaList;
	}

	public void setEmpresaList(LazyDataModel<Pessoa> empresaList) {
		this.empresaList = empresaList;
	}

	public EmpresaRN getEmpRN() {
		if(this.empRN == null){
			this.empRN = new EmpresaRN();
		}
		return empRN;
	}

	public void setEmpRN(EmpresaRN empRN) {
		this.empRN = empRN;
	}
}
