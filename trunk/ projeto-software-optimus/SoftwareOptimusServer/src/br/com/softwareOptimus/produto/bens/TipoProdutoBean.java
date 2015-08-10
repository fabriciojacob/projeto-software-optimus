package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.Ncm;
import br.com.softwareOptimus.fiscal.PisCofins;
import br.com.softwareOptimus.fiscal.TipoCst;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.fiscal.RN.TipoProdutoRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "tipoProdutoBean")
@ViewScoped
public class TipoProdutoBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = -2984908303662738172L;
	private TipoProduto tipo;
	private CodTabelaGov tbGov;
	private Ncm ncm;
	private List<TipoProduto> listaTipoProduto;
	private List<Aliquota> listaAliqPis;
	private List<Aliquota> listaAliqCofins;
	private List<Ncm> listaNcm;
	private List<Aliquota> listaAliqIpi;
	private AliquotaRN aliqRN;
	private TipoProdutoRN tipoRN;
	private List<CodTabelaGov> listaTbGov;
	private boolean sal = true;
	private boolean alt = true;
	private boolean rem = true;
	private boolean vig = true;
	private boolean desc = true;
	private String busca, filtro;
	private Long id;
	private Long idVig;
	private Long idNcm;

	public TipoProdutoBean() {
		setListaAliqPis(this.getAliqRN().listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.PIS));
		setListaAliqCofins(this.getAliqRN().listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.COFINS));
		setListaAliqIpi(this.getAliqRN().listaAliq(TipoCst.IPI));
	}

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(true);
		setListaAliqPis(this.getAliqRN().listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.PIS));
		setListaAliqCofins(this.getAliqRN().listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.COFINS));
		setListaAliqIpi(this.getAliqRN().listaAliq(TipoCst.IPI));
		limpar();
		habilita();
	}

	public void salvar() {
		try {
			this.getTipo().setIdTipoProd(null);
			Integer retorno = this.getTipoRN().validaCampoNulo(this.getTipo());
			if (retorno == 0) {
				this.getTipoRN().salvar(this.getTipo());
				this.info("Tipo de Produto salvo com sucesso");
				this.setVig(false);
				this.setSal(true);
				this.setAlt(false);
				this.setRem(false);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravação do Tipo de Produto " 	+ e.getMessage());
		}
	}

	public void alterar() {
		try {
			Integer retorno = this.getTipoRN().validaCampoNulo(this.getTipo());
			if (retorno == 0) {
				this.getTipoRN().altTipo(this.getTipo());
				this.info("Tipo de Produto alterado com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração do Tipo de Produto " + e.getMessage());
		}
	}

	public void remover() {
		try {
			Integer retorno = this.getTipoRN().verificaRemocao(this.getTipo());
			if (retorno == 0) {
				this.getTipoRN().remover(this.getTipo());
				this.info("Tipo de Produto removido com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem Produtos vinculados a este Tipo. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção do Tipo de Produto " + e.getMessage());
		}
	}

	public void cancelar() {
		this.setSal(true);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(true);
		limpar();
		desabilita();
	}

	public void buscarNcm() {
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("codNcm")) {
				this.setListaNcm(this.getTipoRN().consultaNCMCod(this.getBusca()));
			} else if (this.getFiltro().equals("descNcm")) {
				this.setListaNcm(this.getTipoRN().consultaNCMDesc(this.getBusca()));
			} else if (this.getFiltro().equals("descNat")) {
				this.setListaNcm(this.getTipoRN().consultaNatDesc(this.getBusca()));
			} else if (this.getFiltro().equals("codNat")) {
				this.setListaNcm(this.getTipoRN().consultaNatCod(this.getBusca()));
			} else if (this.getFiltro().equals("descTb")) {
				this.setListaNcm(this.getTipoRN().consultaTbDesc(this.getBusca()));
			}
		} else {
			this.error("Para listar os NCM inclua um parâmentro.");
		}
	}

	public void vincularNcm() {
		this.setNcm(this.getTipoRN().consultaNCMId(this.getIdNcm()));
		this.getTbGov().setNcm(this.getNcm());
		this.info("Ncm Vinculado ao Tipo!");
	}

	public void excluirVigTip() {
		try {
			this.getTipoRN().removerVig(this.getIdVig());
			listaVigencia();
			this.info("Vigência do tipo de produto removido com sucesso");
		} catch (Exception e) {
			this.error("Problemas na remoção da vigência do tipo de produto " + e.getMessage());
		}
	}

	public void editarVigTip() {
		try {
			this.setTbGov(this.getTipoRN().editVig(this.getIdVig()));
		} catch (Exception e) {
			this.error("Problemas na remoção da vigência do tipo de produto " + e.getMessage());
		}
	}

	public void buscarTipo() {
		limpar();
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("id")) {
				this.setListaTipoProduto(this.getTipoRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("desc")) {
				this.setListaTipoProduto(this.getTipoRN().consultaDesc(this.getBusca()));
			}
		} else {
			this.setListaTipoProduto(this.getTipoRN().listar());
		}
	}
	
	public void tipoProdutoSelecionado(SelectEvent event){
		TipoProduto tipo;
		tipo = (TipoProduto) event.getObject();
		this.setTipo(this.getTipoRN().editTipo(tipo.getIdTipoProd()));
		listaVigencia();
		habilita();
		this.setAlt(false);
		this.setVig(false);
		this.setRem(false);
		this.setSal(true);		
	}

	public void incluirTipoVig() {
		try {
			if (this.getTbGov().getIdCodGov() == null) {
				this.getTbGov().setIdCodGov(null);
				this.getTbGov().setTipoProduto(this.getTipo());
				Integer retorno = this.getTipoRN().validaCampoNuloVig(this.getTbGov());
				if (retorno == 0) {
					this.getTipoRN().salvaVig(this.getTbGov());
					listaVigencia();
					this.info("Vigência salva com sucesso");
					this.setTbGov(null);
				} else {
					this.error("Existem campos nulos no formulário");
				}
			} else {
				Integer retorno = this.getTipoRN().validaCampoNuloVig(this.getTbGov());
				if (retorno == 0) {
					this.getTipoRN().salvaVig2(getTbGov());
					listaVigencia();
					this.info("Vigência salva com sucesso");
					this.setTbGov(new CodTabelaGov());
				} else {
					this.error("Existem campos nulos no formulário");
				}
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Vigência " + e.getMessage());
		}
	}

	public void incVigNovo() {
		this.setTbGov(null);
	}

	public void limpar() {
		this.setTipo(null);
		this.setTbGov(null);
		this.setListaTipoProduto(null);
		this.setListaTbGov(null);
		this.setNcm(null);
		this.setListaNcm(null);
	}

	public void listaVigencia() {
		try {
			this.getListaTbGov().clear();
			this.setListaTbGov(this.getTipoRN().listarVig(this.getTipo()));
		} catch (Exception e) {
			this.error("Problemas ao listar as Vigências " + e.getMessage());
		}
	}

	public void habilita() {
		this.desc = false;
	}

	public void desabilita() {
		this.desc = true;
	}

	public Long getIdNcm() {
		return idNcm;
	}

	public void setIdNcm(Long idNcm) {
		this.idNcm = idNcm;
	}

	public List<Aliquota> getListaAliqPis() {
		if(this.listaAliqPis == null){
			this.listaAliqPis = new ArrayList<Aliquota>();
		}
		return listaAliqPis;
	}

	public void setListaAliqPis(List<Aliquota> listaAliqPis) {
		this.listaAliqPis = listaAliqPis;
	}

	public List<Aliquota> getListaAliqCofins() {
		if(this.listaAliqCofins == null){
			this.listaAliqCofins = new ArrayList<Aliquota>();
		}
		return listaAliqCofins;
	}

	public void setListaAliqCofins(List<Aliquota> listaAliqCofins) {
		this.listaAliqCofins = listaAliqCofins;
	}

	public Ncm getNcm() {
		if(this.ncm == null){
			this.ncm = new Ncm();
		}
		return ncm;
	}

	public void setNcm(Ncm ncm) {
		this.ncm = ncm;
	}

	public List<Ncm> getListaNcm() {
		if(this.listaNcm == null){
			this.listaNcm = new ArrayList<Ncm>();
		}
		return listaNcm;
	}

	public void setListaNcm(List<Ncm> listaNcm) {
		this.listaNcm = listaNcm;
	}

	public List<Aliquota> getListaAliqIpi() {
		if(this.listaAliqIpi == null){
			this.listaAliqIpi = new ArrayList<Aliquota>();
		}
		return listaAliqIpi;
	}

	public void setListaAliqIpi(List<Aliquota> listaAliqIpi) {
		this.listaAliqIpi = listaAliqIpi;
	}

	public TipoProduto getTipo() {
		if(this.tipo == null){
			this.tipo = new TipoProduto();
		}
		return tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}

	public List<TipoProduto> getListaTipoProduto() {
		if(this.listaTipoProduto == null){
			this.listaTipoProduto = new ArrayList<TipoProduto>();
		}
		return listaTipoProduto;
	}

	public void setListaTipoProduto(List<TipoProduto> listaTipoProduto) {
		this.listaTipoProduto = listaTipoProduto;
	}

	public boolean isVig() {
		return vig;
	}

	public void setVig(boolean vig) {
		this.vig = vig;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdVig() {
		return idVig;
	}

	public void setIdVig(Long idVig) {
		this.idVig = idVig;
	}

	public boolean isSal() {
		return sal;
	}

	public void setSal(boolean sal) {
		this.sal = sal;
	}

	public boolean isAlt() {
		return alt;
	}

	public void setAlt(boolean alt) {
		this.alt = alt;
	}

	public boolean isRem() {
		return rem;
	}

	public void setRem(boolean rem) {
		this.rem = rem;
	}

	public CodTabelaGov getTbGov() {
		if(this.tbGov == null){
			this.tbGov = new CodTabelaGov();
		}
		return tbGov;
	}

	public void setTbGov(CodTabelaGov tbGov) {
		this.tbGov = tbGov;
	}

	public List<CodTabelaGov> getListaTbGov() {
		if(this.listaTbGov == null){
			this.listaTbGov = new ArrayList<CodTabelaGov>();
		}
		return listaTbGov;
	}

	public void setListaTbGov(List<CodTabelaGov> listaTbGov) {
		this.listaTbGov = listaTbGov;
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

	public TipoProdutoRN getTipoRN() {
		if(this.tipoRN == null){
			this.tipoRN = new TipoProdutoRN();			
		}
		return tipoRN;
	}

	public void setTipoRN(TipoProdutoRN tipoRN) {
		this.tipoRN = tipoRN;
	}
}
