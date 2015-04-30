package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	private TipoProduto tipo = new TipoProduto();
	private CodTabelaGov tbGov = new CodTabelaGov();
	private Ncm ncm = new Ncm();
	private List<TipoProduto> listaTipoProduto = new ArrayList<TipoProduto>();
	private List<Aliquota> listaAliqPis = new ArrayList<Aliquota>();
	private List<Aliquota> listaAliqCofins = new ArrayList<Aliquota>();
	private List<Ncm> listaNcm = new ArrayList<Ncm>();
	private List<Aliquota> listaAliqIpi = new ArrayList<Aliquota>();
	private AliquotaRN aliqRN = new AliquotaRN();
	private List<CodTabelaGov> listaTbGov = new ArrayList<CodTabelaGov>();
	private boolean sal = true, alt = true, rem = true, vig = true,
			desc = true;
	private String busca, filtro;
	private Long id, idVig, idNcm;

	public TipoProdutoBean() {
		setListaAliqPis(this.aliqRN.listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.PIS));
		setListaAliqCofins(this.aliqRN.listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.COFINS));
		setListaAliqIpi(this.aliqRN.listaAliq(TipoCst.IPI));
	}

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		setListaAliqPis(this.aliqRN.listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.PIS));
		setListaAliqCofins(this.aliqRN.listaAliqPisCofins(TipoCst.PISCOFINS, PisCofins.COFINS));
		setListaAliqIpi(this.aliqRN.listaAliq(TipoCst.IPI));
		limpar();
		habilita();
	}

	public void salvar() {
		try {
			TipoProdutoRN tipoRN = new TipoProdutoRN();
			this.tipo.setIdTipoProd(null);
			Integer retorno = tipoRN.validaCampoNulo(this.tipo);
			if (retorno == 0) {
				tipoRN.salvar(this.tipo);
				this.info("Tipo de Produto salvo com sucesso");
				this.vig = false;
				this.sal = true;
				this.alt = false;
				this.rem = false;
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravação do Tipo de Produto " 	+ e.getMessage());
		}
	}

	public void alterar() {
		try {
			TipoProdutoRN tipoRN = new TipoProdutoRN();
			Integer retorno = tipoRN.validaCampoNulo(this.tipo);
			if (retorno == 0) {
				tipoRN.altTipo(this.tipo);
				this.info("Tipo de Produto alterado com sucesso");
				this.alt = true;
				this.rem = true;
				this.vig = true;
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
			TipoProdutoRN tipoRN = new TipoProdutoRN();
			Integer retorno = tipoRN.verificaRemocao(this.tipo);
			if (retorno == 0) {
				tipoRN.remover(this.tipo);
				this.info("Tipo de Produto removido com sucesso");
				this.alt = true;
				this.rem = true;
				this.vig = true;
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
		this.sal = true;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		limpar();
		desabilita();
	}

	public void buscarNcm() {
		TipoProdutoRN tipoRN = new TipoProdutoRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("codNcm")) {
				this.listaNcm = tipoRN.consultaNCMCod(busca);
			} else if (filtro.equals("descNcm")) {
				this.listaNcm = tipoRN.consultaNCMDesc(busca);
			} else if (filtro.equals("descNat")) {
				this.listaNcm = tipoRN.consultaNatDesc(busca);
			} else if (filtro.equals("codNat")) {
				this.listaNcm = tipoRN.consultaNatCod(busca);
			} else if (filtro.equals("descTb")) {
				this.listaNcm = tipoRN.consultaTbDesc(busca);
			}
		} else {
			this.error("Para listar os NCM inclua um parâmentro.");
		}
	}

	public void vincularNcm() {
		TipoProdutoRN tipoRN = new TipoProdutoRN();
		this.ncm = tipoRN.consultaNCMId(this.idNcm);
		this.tbGov.setNcm(ncm);
		this.info("Ncm Vinculado ao Tipo!");
	}

	public void excluirVigTip() {
		try {
			TipoProdutoRN tipoRN = new TipoProdutoRN();
			tipoRN.removerVig(this.idVig);
			listaVigencia();
			this.info("Vigência do tipo de produto removido com sucesso");
		} catch (Exception e) {
			this.error("Problemas na remoção da vigência do tipo de produto " + e.getMessage());
		}
	}

	public void editarVigTip() {
		try {
			TipoProdutoRN tipoRN = new TipoProdutoRN();
			this.tbGov = tipoRN.editVig(this.idVig);
		} catch (Exception e) {
			this.error("Problemas na remoção da vigência do tipo de produto " + e.getMessage());
		}
	}

	public void buscarTipo() {
		limpar();
		TipoProdutoRN tipoRN = new TipoProdutoRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaTipoProduto = tipoRN
						.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.listaTipoProduto = tipoRN.consultaDesc(busca);
			}
		} else {
			this.listaTipoProduto = tipoRN.listar();
		}
	}

	public void editTipo() {
		TipoProdutoRN tipoRN = new TipoProdutoRN();
		this.tipo = tipoRN.editTipo(id);
		listaVigencia();
		habilita();
		this.alt = false;
		this.vig = false;
		this.rem = false;
		this.sal = true;
	}

	public void incluirTipoVig() {
		try {
			TipoProdutoRN tipoRN = new TipoProdutoRN();
			if (this.tbGov.getIdCodGov() == null) {
				this.tbGov.setIdCodGov(null);
				this.tbGov.setTipoProduto(this.tipo);
				Integer retorno = tipoRN.validaCampoNuloVig(this.tbGov);
				if (retorno == 0) {
					tipoRN.salvaVig(this.tbGov);
					listaVigencia();
					this.info("Vigência salva com sucesso");
					this.tbGov = new CodTabelaGov();
				} else {
					this.error("Existem campos nulos no formulário");
				}
			} else {
				Integer retorno = tipoRN.validaCampoNuloVig(this.tbGov);
				if (retorno == 0) {
					tipoRN.salvaVig2(this.tbGov);
					listaVigencia();
					this.info("Vigência salva com sucesso");
					this.tbGov = new CodTabelaGov();
				} else {
					this.error("Existem campos nulos no formulário");
				}
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Vigência " + e.getMessage());
		}
	}

	public void incVigNovo() {
		this.tbGov = new CodTabelaGov();
	}

	public void limpar() {
		this.tipo = new TipoProduto();
		this.tbGov = new CodTabelaGov();
		this.listaTipoProduto = new ArrayList<TipoProduto>();
		this.listaTbGov = new ArrayList<CodTabelaGov>();
		this.ncm = new Ncm();
		this.listaNcm = new ArrayList<Ncm>();
	}

	public void listaVigencia() {
		try {
			TipoProdutoRN tipoRN = new TipoProdutoRN();
			if (this.listaTbGov != null) {
				this.listaTbGov.clear();
			}
			this.listaTbGov = tipoRN.listarVig(this.tipo);
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
		return listaAliqPis;
	}

	public void setListaAliqPis(List<Aliquota> listaAliqPis) {
		this.listaAliqPis = listaAliqPis;
	}

	public List<Aliquota> getListaAliqCofins() {
		return listaAliqCofins;
	}

	public void setListaAliqCofins(List<Aliquota> listaAliqCofins) {
		this.listaAliqCofins = listaAliqCofins;
	}

	public Ncm getNcm() {
		return ncm;
	}

	public void setNcm(Ncm ncm) {
		this.ncm = ncm;
	}

	public List<Ncm> getListaNcm() {
		return listaNcm;
	}

	public void setListaNcm(List<Ncm> listaNcm) {
		this.listaNcm = listaNcm;
	}

	public List<Aliquota> getListaAliqIpi() {
		return listaAliqIpi;
	}

	public void setListaAliqIpi(List<Aliquota> listaAliqIpi) {
		this.listaAliqIpi = listaAliqIpi;
	}

	public TipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}

	public List<TipoProduto> getListaTipoProduto() {
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
		return tbGov;
	}

	public void setTbGov(CodTabelaGov tbGov) {
		this.tbGov = tbGov;
	}

	public List<CodTabelaGov> getListaTbGov() {
		return listaTbGov;
	}

	public void setListaTbGov(List<CodTabelaGov> listaTbGov) {
		this.listaTbGov = listaTbGov;
	}
}
