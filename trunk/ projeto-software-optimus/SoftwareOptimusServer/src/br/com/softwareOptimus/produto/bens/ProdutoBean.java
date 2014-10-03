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
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	private FiguraFiscalRN figRN = new FiguraFiscalRN();
	private UnidMedRN unidRN = new UnidMedRN();
	private SubGrupoRN subRN = new SubGrupoRN();
	private GrupoRN gruRN = new GrupoRN();
	private SetorRN setRN = new SetorRN();
	private TipoProdutoRN tipRN = new TipoProdutoRN();
	private boolean sal = true, alt = true, rem = true;
	
	public ProdutoBean(){
		setListaUnidade(this.unidRN.lista());
		setListaTipo(this.tipRN.listarTipoVig());
		setListaFigura(this.figRN.listar());
		setListaSetor(this.setRN.listar());
	}

	public void salvar() {
		try {
			ProdutoRN produtoRN = new ProdutoRN();
			produtoRN.salvar(produto);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Produto salvo com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao do produto "
									+ e.getMessage()));
		}

	}
	
	public void novo(){
		
	}
	
	public void alterar(){
		
	}
	
	public void remover(){
		
	}
	
	public void cancelar(){
		
	}
	
	public void limpar(){
		
	}
	
	public void habilita(){
		
	}
	
	public void desabilita(){
		
	}
	
	public void filtraGrupo(){
		setListaGrupo(this.gruRN.listaGrupoVincSet(this.produto.getSetor()));
	}
	
	public void filtraSubGrupo(){
		setListaSubGrupo(this.subRN.listaSubGrupoVincGrupo(this.produto.getGrupo()));
	}
	
	public void filtraCategoria(){
		setListaCategoria(this.subRN.listarCatg(this.produto.getSubGrupo()));		
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
