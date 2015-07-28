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

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaAliquotaBean")
@ViewScoped
public class PesquisaAliquotaBean extends FacesUtil implements Serializable {

	private Double maxAliquota;
	private Double minAliquota;
	private Double maxReduc;
	private Double minReduc;
	private AliquotaRN aliqRN;
	private LazyDataModel<Aliquota> aliquotaList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaAliquotaBean(){
		aliquotaList = new LazyDataModel<Aliquota>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<Aliquota> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getAliqRN().countAliquotaPaginacao(getMaxAliquota(), getMinAliquota(), getMaxReduc(), getMinReduc()));
				return getAliqRN().buscaAliquotaPaginacao(getMaxAliquota(), getMinAliquota(), getMaxReduc(), getMinReduc(), first, pageSize);
			}
		};
	}
	
	public void selecionaAliquota(Aliquota aliquota){
		RequestContext.getCurrentInstance().closeDialog(aliquota);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaAliquota", opcoes, null);
	}

	public Double getMaxAliquota() {
		return maxAliquota;
	}

	public void setMaxAliquota(Double maxAliquota) {
		this.maxAliquota = maxAliquota;
	}

	public Double getMinAliquota() {
		return minAliquota;
	}

	public void setMinAliquota(Double minAliquota) {
		this.minAliquota = minAliquota;
	}

	public Double getMaxReduc() {
		return maxReduc;
	}

	public void setMaxReduc(Double maxReduc) {
		this.maxReduc = maxReduc;
	}

	public Double getMinReduc() {
		return minReduc;
	}

	public void setMinReduc(Double minReduc) {
		this.minReduc = minReduc;
	}

	public AliquotaRN getAliqRN() {
		if(this.aliqRN == null){
			this.aliqRN = new AliquotaRN();
		}
		return aliqRN;
	}

	public void setAliqRN(AliquotaRN aliqRN) {
		this.aliqRN = aliqRN;
	}

	public LazyDataModel<Aliquota> getAliquotaList() {
		return aliquotaList;
	}

	public void setAliquotaList(LazyDataModel<Aliquota> aliquotaList) {
		this.aliquotaList = aliquotaList;
	}
}
