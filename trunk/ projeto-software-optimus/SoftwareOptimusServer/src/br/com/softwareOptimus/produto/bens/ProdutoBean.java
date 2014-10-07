package br.com.softwareOptimus.produto.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

@ManagedBean(name = "produtoBean")
@ViewScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<FiguraFiscal> listaFigura = new ArrayList<FiguraFiscal>();
	private List<UnidMed> listaUnidade = new ArrayList<UnidMed>();
	private List<TipoProduto> listaTipo = new ArrayList<TipoProduto>();
	private List<Setor> listaSetor = new ArrayList<Setor>();
	private List<Grupo> listaGrupo = new ArrayList<Grupo>();
	private List<SubGrupo> listaSubGrupo = new ArrayList<SubGrupo>();
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	private FiguraFiscalRN figRN = new FiguraFiscalRN();
	private UnidMedRN unidRN = new UnidMedRN();
	private SubGrupoRN subRN = new SubGrupoRN();
	private GrupoRN gruRN = new GrupoRN();
	private SetorRN setRN = new SetorRN();
	private String busca, filtro;
	private Long id;
	private TipoProdutoRN tipRN = new TipoProdutoRN();
	private boolean sal = true, alt = true, rem = true, sta = true,
			desc = true, codBarra = true, fig = true, unid = true,
			tipoProd = true, set = true, gru = true, subGru = true, categ = true;

	public ProdutoBean() {
		setListaUnidade(this.unidRN.lista());
		setListaTipo(this.tipRN.listarTipoVig());
		setListaFigura(this.figRN.listar());
		setListaSetor(this.setRN.listar());
	}

	public void salvar() {
		try {
			ProdutoRN proRN = new ProdutoRN();
			this.produto.setIdProduto(null);
			Integer retorno = proRN.validaCampoNulo(this.produto);
			if (retorno == 0) {
				proRN.salvar(this.produto);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Produto salvo com sucesso"));
				this.sal = true;
				this.alt = true;
				this.rem = true;
				limpar();
				desabilita();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na gravacao do Produto "
											+ e.getMessage()));
		}
	}

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		limpar();
		habilita();
	}

	public void alterar() {
		try {
			ProdutoRN prodRN = new ProdutoRN();
			Integer retorno = prodRN.validaCampoNulo(this.produto);
			if (retorno == 0) {
				prodRN.altPro(this.produto);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Produto alterado com sucesso"));
				this.alt = true;
				this.rem = true;
				this.sal = true;
				limpar();
				desabilita();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na alteração do Produto "
											+ e.getMessage()));
		}
	}

	public void remover() {
		try {
			ProdutoRN proRN = new ProdutoRN();
			Integer retorno = proRN.verificaRemocao(this.produto);
			if (retorno == 0) {
				proRN.remover(this.produto);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Produto removido com sucesso"));
				this.alt = true;
				this.rem = true;
				limpar();
				desabilita();
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
										"Info",
										"Remoção não permitida! Existem Registros vinculados a este Produto. "));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção do Produto " + e.getMessage()));
		}
	}
	
	public void buscarProd(){
		limpar();
		ProdutoRN proRN = new ProdutoRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaProduto = proRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.listaProduto = proRN.consultaDesc(busca);
			}
		} else {
			this.listaProduto = proRN.listar();
		}
	}
	
	public void editProduto(){
		ProdutoRN proRN = new ProdutoRN();
		this.produto = proRN.editPro(this.id);
		filtraGrupo();
		filtraSubGrupo();
		filtraCategoria();
		habilita();
		this.alt = false;
		this.rem = false;
		this.sal = true;	
	}

	public void cancelar() {
		this.sal = true;
		this.alt = true;
		this.rem = true;
		limpar();
		desabilita();
	}

	public void limpar() {
		this.produto = new Produto();
		this.listaFigura = new ArrayList<FiguraFiscal>();
		this.listaProduto = new ArrayList<Produto>();
		this.listaUnidade = new ArrayList<UnidMed>();
		this.listaTipo = new ArrayList<TipoProduto>();
		this.listaSetor = new ArrayList<Setor>();
		this.listaGrupo = new ArrayList<Grupo>();
		this.listaSubGrupo = new ArrayList<SubGrupo>();
		this.listaCategoria = new ArrayList<Categoria>();
		setListaUnidade(this.unidRN.lista());
		setListaTipo(this.tipRN.listarTipoVig());
		setListaFigura(this.figRN.listar());
		setListaSetor(this.setRN.listar());
	}

	public void habilita() {
		this.sta = false;
		this.desc = false;
		this.codBarra = false;
		this.fig = false;
		this.unid = false;
		this.tipoProd = false;
		this.set = false;
		this.gru = false;
		this.subGru = false;
		this.categ = false;
	}

	public void desabilita() {
		this.sta = true;
		this.desc = true;
		this.codBarra = true;
		this.fig = true;
		this.unid = true;
		this.tipoProd = true;
		this.set = true;
		this.gru = true;
		this.subGru = true;
		this.categ = true;
	}

	public void filtraGrupo() {
		setListaGrupo(this.gruRN.listaGrupoVincSet(this.produto.getSetor()));
		this.listaSubGrupo = new ArrayList<SubGrupo>();
		this.listaCategoria = new ArrayList<Categoria>();
	}

	public void filtraSubGrupo() {
		setListaSubGrupo(this.subRN.listaSubGrupoVincGrupo(this.produto
				.getGrupo()));
	}

	public void filtraCategoria() {
		setListaCategoria(this.subRN.listarCatg(this.produto.getSubGrupo()));
	}

	public List<Produto> getListaProduto() {
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
		return listaSetor;
	}

	public void setListaSetor(List<Setor> listaSetor) {
		this.listaSetor = listaSetor;
	}

	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}

	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
	}

	public List<SubGrupo> getListaSubGrupo() {
		return listaSubGrupo;
	}

	public void setListaSubGrupo(List<SubGrupo> listaSubGrupo) {
		this.listaSubGrupo = listaSubGrupo;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public List<TipoProduto> getListaTipo() {
		return listaTipo;
	}

	public List<UnidMed> getListaUnidade() {
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
		return listaFigura;
	}

	public void setListaFigura(List<FiguraFiscal> listaFigura) {
		this.listaFigura = listaFigura;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
