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

import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.RN.ParticipanteRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaPessoaFisicaBean")
@ViewScoped
public class PesquisaPessoaFisicaBean extends FacesUtil implements Serializable {

	private static final long serialVersionUID = 5527469039512067571L;
	
	private PessoaFisica pessoaFisica;
	private LazyDataModel<PessoaFisica> pessoaFisicaList;
	private ParticipanteRN partRN;

	public PesquisaPessoaFisicaBean(){
		pessoaFisicaList = new LazyDataModel<PessoaFisica>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<PessoaFisica> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getPartRN().countPessoaFisicaPaginacao(getPessoaFisica()));
				return getPartRN().buscaPessoaFisicaPaginacao(getPessoaFisica(), first, pageSize);
			}
		};
	}
	
	public void selecionaPessoa(PessoaFisica pj){
		RequestContext.getCurrentInstance().closeDialog(pj);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaPessoaFisica", opcoes, null);
	}
	public PessoaFisica getPessoaFisica() {
		if(this.pessoaFisica == null){
			this.pessoaFisica = new PessoaFisica();
		}
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	public LazyDataModel<PessoaFisica> getPessoaFisicaList() {
		return pessoaFisicaList;
	}
	public void setPessoaFisicaList(LazyDataModel<PessoaFisica> pessoaFisicaList) {
		this.pessoaFisicaList = pessoaFisicaList;
	}
	public ParticipanteRN getPartRN() {
		if(this.partRN == null){
			this.partRN = new ParticipanteRN();
		}
		return partRN;
	}
	public void setPartRN(ParticipanteRN partRN) {
		this.partRN = partRN;
	}
}