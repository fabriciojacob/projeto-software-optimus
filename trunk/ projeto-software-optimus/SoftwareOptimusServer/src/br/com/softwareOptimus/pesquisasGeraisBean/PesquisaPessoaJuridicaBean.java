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

import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.RN.ParticipanteRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaPessoaJuridicaBean")
@ViewScoped
public class PesquisaPessoaJuridicaBean extends FacesUtil implements Serializable {
	
	private PessoaJuridica pessoaJuridica;
	private LazyDataModel<PessoaJuridica> pessoaJuridicaList;
	private ParticipanteRN partRN;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaPessoaJuridicaBean(){
		pessoaJuridicaList = new LazyDataModel<PessoaJuridica>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<PessoaJuridica> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getPartRN().countPessoaJuridicaPaginacao(getPessoaJuridica()));
				return getPartRN().buscaPessoaJuridicaPaginacao(getPessoaJuridica(), first, pageSize);
			}
		};
	}
	
	public void selecionaPessoa(PessoaJuridica pj){
		RequestContext.getCurrentInstance().closeDialog(pj);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 1000);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaPessoaJuridica", opcoes, null);
	}
	public PessoaJuridica getPessoaJuridica() {
		if(this.pessoaJuridica == null){
			this.pessoaJuridica = new PessoaJuridica();
		}
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public LazyDataModel<PessoaJuridica> getPessoaJuridicaList() {
		return pessoaJuridicaList;
	}
	public void setPessoaJuridicaList(
			LazyDataModel<PessoaJuridica> pessoaJuridicaList) {
		this.pessoaJuridicaList = pessoaJuridicaList;
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
