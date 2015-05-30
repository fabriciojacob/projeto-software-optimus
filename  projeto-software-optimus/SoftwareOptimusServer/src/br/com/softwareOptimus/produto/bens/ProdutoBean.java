package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.fiscal.RN.FiguraFiscalRN;
import br.com.softwareOptimus.fiscal.RN.TipoProdutoRN;
import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.produto.RN.GrupoRN;
import br.com.softwareOptimus.produto.RN.ProdutoRN;
import br.com.softwareOptimus.produto.RN.SetorRN;
import br.com.softwareOptimus.produto.RN.SubGrupoRN;
import br.com.softwareOptimus.produto.RN.UnidMedRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "produtoBean")
@ViewScoped
public class ProdutoBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = 8953487771453312466L;
	private Produto produto;
	private List<FiguraFiscal> listaFigura;
	private List<UnidMed> listaUnidade;
	private List<TipoProduto> listaTipo;
	private List<Setor> listaSetor;
	private List<Grupo> listaGrupo;
	private List<SubGrupo> listaSubGrupo;
	private List<Produto> listaProduto;
	private List<Categoria> listaCategoria;
	private FiguraFiscalRN figRN;
	private UnidMedRN unidRN;
	private SubGrupoRN subRN;
	private GrupoRN gruRN;
	private SetorRN setRN;
	private String busca, filtro;
	private Long id;
	private TipoProdutoRN tipRN;
	private ProdutoRN proRN;
	private boolean sal = true;
	private boolean alt = true;
	private boolean rem = true;
	private boolean sta = true;
	private boolean desc = true;
	private boolean codBarra = true;
	private boolean fig = true;
	private boolean unid = true;
	private boolean tipoProd = true;
	private boolean set = true;
	private boolean gru = true;
	private boolean subGru = true;
	private boolean categ = true;

	public ProdutoBean() {
		setListaUnidade(this.getUnidRN().lista());
		setListaTipo(this.getTipRN().listarTipoVig());
		setListaFigura(this.getFigRN().listar());
		setListaSetor(this.getSetRN().listar());
	}

	public void salvar() {
		try {
			this.getProduto().setIdProduto(null);
			Integer retorno = this.getProRN().validaCampoNulo(this.getProduto());
			if (retorno == 0) {
				this.getProRN().salvar(this.getProduto());
				this.info("Produto salvo com sucesso");
				this.setSal(true);
				this.setAlt(true);
				this.setRem(true);
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao do Produto " + e.getMessage());
		}
	}

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		limpar();
		habilita();
	}

	public void alterar() {
		try {
			Integer retorno = this.getProRN().validaCampoNulo(this.getProduto());
			if (retorno == 0) {
				this.getProRN().altPro(this.getProduto());
				this.info("Produto alterado com sucesso");
				this.setSal(true);
				this.setAlt(true);
				this.setRem(true);
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração do Produto ");
		}
	}

	public void remover() {
		try {
			Integer retorno = this.getProRN().verificaRemocao(this.getProduto());
			if (retorno == 0) {
				this.getProRN().remover(this.getProduto());
				this.info("Produto removido com sucesso");
				this.setAlt(true);
				this.setRem(true);
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem Registros vinculados a este Produto. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção do Produto " + e.getMessage());
		}
	}
	
	public void buscarProd(){
		limpar();
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("id")) {
				this.setListaProduto(this.getProRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("desc")) {
				this.setListaProduto(this.getProRN().consultaDesc(this.getBusca()));
			}
		} else {
			this.setListaProduto(this.getProRN().listar());
		}
	}
	
	public void editProduto(){
		this.setProduto(this.getProRN().editPro(this.getId()));
		filtraGrupo();
		filtraSubGrupo();
		filtraCategoria();
		habilita();
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
	}

	public void cancelar() {
		this.setSal(true);
		this.setAlt(true);
		this.setRem(true);
		limpar();
		desabilita();
	}

	public void limpar() {
		this.setProduto(null);
		this.setListaFigura(null);
		this.setListaProduto(null);
		this.setListaUnidade(null);
		this.setListaTipo(null);
		this.setListaSetor(null);
		this.setListaGrupo(null);
		this.setListaSubGrupo(null);
		this.setListaCategoria(null);
		this.setListaUnidade(this.getUnidRN().lista());
		this.setListaTipo(this.getTipRN().listarTipoVig());
		this.setListaFigura(this.getFigRN().listar());
		this.setListaSetor(this.getSetRN().listar());
	}

	public void habilita() {
		this.setSta(false);
		this.setDesc(false);
		this.setCodBarra(false);
		this.setFig(false);
		this.setUnid(false);
		this.setTipoProd(false);
		this.setSet(false);
		this.setGru(false);
		this.setSubGru(false);
		this.setCateg(false);
	}

	public void desabilita() {
		this.setSta(true);
		this.setDesc(true);
		this.setCodBarra(true);
		this.setFig(true);
		this.setUnid(true);
		this.setTipoProd(true);
		this.setSet(true);
		this.setGru(true);
		this.setSubGru(true);
		this.setCateg(true);
	}

	public void filtraGrupo() {
		setListaGrupo(this.getGruRN().listaGrupoVincSet(this.getProduto().getSetor()));
		this.setListaSubGrupo(null);
		this.setListaCategoria(null);
	}

	public void filtraSubGrupo() {
		setListaSubGrupo(this.getSubRN().listaSubGrupoVincGrupo(this.getProduto().getGrupo()));
	}

	public void filtraCategoria() {
		setListaCategoria(this.getSubRN().listarCatg(this.getProduto().getSubGrupo()));
	}

	public List<Produto> getListaProduto() {
		if(this.listaProduto == null){
			this.listaProduto = new ArrayList<Produto>();
		}
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public String getBusca() {
		return busca;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isSta() {
		return sta;
	}

	public void setSta(boolean sta) {
		this.sta = sta;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public boolean isCodBarra() {
		return codBarra;
	}

	public void setCodBarra(boolean codBarra) {
		this.codBarra = codBarra;
	}

	public boolean isFig() {
		return fig;
	}

	public void setFig(boolean fig) {
		this.fig = fig;
	}

	public boolean isUnid() {
		return unid;
	}

	public void setUnid(boolean unid) {
		this.unid = unid;
	}

	public boolean isTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(boolean tipoProd) {
		this.tipoProd = tipoProd;
	}

	public boolean isSet() {
		return set;
	}

	public void setSet(boolean set) {
		this.set = set;
	}

	public boolean isGru() {
		return gru;
	}

	public void setGru(boolean gru) {
		this.gru = gru;
	}

	public boolean isSubGru() {
		return subGru;
	}

	public void setSubGru(boolean subGru) {
		this.subGru = subGru;
	}

	public boolean isCateg() {
		return categ;
	}

	public void setCateg(boolean categ) {
		this.categ = categ;
	}

	public List<Setor> getListaSetor() {
		if(this.listaSetor == null){
			this.listaSetor = new ArrayList<Setor>();
		}
		return listaSetor;
	}

	public void setListaSetor(List<Setor> listaSetor) {
		this.listaSetor = listaSetor;
	}

	public List<Grupo> getListaGrupo() {
		if(this.listaGrupo == null){
			this.listaGrupo = new ArrayList<Grupo>();
		}
		return listaGrupo;
	}

	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
	}

	public List<SubGrupo> getListaSubGrupo() {
		if(this.listaSubGrupo == null){
			this.listaSubGrupo = new ArrayList<SubGrupo>();
		}
		return listaSubGrupo;
	}

	public void setListaSubGrupo(List<SubGrupo> listaSubGrupo) {
		this.listaSubGrupo = listaSubGrupo;
	}

	public List<Categoria> getListaCategoria() {
		if(this.listaCategoria == null){
			this.listaCategoria = new ArrayList<Categoria>();
		}
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public List<TipoProduto> getListaTipo() {
		if(this.listaTipo == null){
			this.listaTipo = new ArrayList<TipoProduto>();
		}
		return listaTipo;
	}

	public List<UnidMed> getListaUnidade() {
		if(this.listaUnidade == null){
			this.listaUnidade = new ArrayList<UnidMed>();
		}
		return listaUnidade;
	}

	public void setListaTipo(List<TipoProduto> listaTipo) {
		this.listaTipo = listaTipo;
	}

	public void setListaUnidade(List<UnidMed> listaUnidade) {
		this.listaUnidade = listaUnidade;
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

	public List<FiguraFiscal> getListaFigura() {
		if(this.listaFigura == null){
			this.listaFigura = new ArrayList<FiguraFiscal>();
		}
		return listaFigura;
	}

	public void setListaFigura(List<FiguraFiscal> listaFigura) {
		this.listaFigura = listaFigura;
	}

	public Produto getProduto() {
		if(this.produto == null){
			this.produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public FiguraFiscalRN getFigRN() {
		if(this.figRN == null){
			this.figRN = new FiguraFiscalRN();			
		}
		return figRN;
	}

	public void setFigRN(FiguraFiscalRN figRN) {
		this.figRN = figRN;
	}

	public UnidMedRN getUnidRN() {
		if(this.unidRN == null){
			this.unidRN = new UnidMedRN();
		}
		return unidRN;
	}

	public void setUnidRN(UnidMedRN unidRN) {
		this.unidRN = unidRN;
	}

	public SubGrupoRN getSubRN() {
		if(this.subRN == null){
			this.subRN = new SubGrupoRN();
		}
		return subRN;
	}

	public void setSubRN(SubGrupoRN subRN) {
		this.subRN = subRN;
	}

	public GrupoRN getGruRN() {
		if(this.gruRN == null){
			this.gruRN = new GrupoRN();
		}
		return gruRN;
	}

	public void setGruRN(GrupoRN gruRN) {
		this.gruRN = gruRN;
	}

	public SetorRN getSetRN() {
		if(this.setRN == null){
			this.setRN = new SetorRN();
		}
		return setRN;
	}

	public void setSetRN(SetorRN setRN) {
		this.setRN = setRN;
	}

	public TipoProdutoRN getTipRN() {
		if(this.tipRN == null){
			this.tipRN = new TipoProdutoRN();
		}
		return tipRN;
	}

	public void setTipRN(TipoProdutoRN tipRN) {
		this.tipRN = tipRN;
	}

	public ProdutoRN getProRN() {
		if(this.proRN == null){
			this.proRN = new ProdutoRN();
		}
		return proRN;
	}

	public void setProRN(ProdutoRN proRN) {
		this.proRN = proRN;
	}
}
