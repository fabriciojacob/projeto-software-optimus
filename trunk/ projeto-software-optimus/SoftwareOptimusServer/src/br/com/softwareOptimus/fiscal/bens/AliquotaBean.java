package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;
import br.com.softwareOptimus.fiscal.RN.CodigoSituacaoTributariaRN;

@ManagedBean(name = "aliquotaBean")
@SessionScoped
public class AliquotaBean {

	private Aliquota aliquota = new Aliquota();
	private CodigoSituacaoTributaria cst = new CodigoSituacaoTributaria();
	private CodigoSituacaoTributaria cstTeste = new CodigoSituacaoTributaria();
	private List<Aliquota> aliqList = new ArrayList<Aliquota>();
	private List<CodigoSituacaoTributaria> cstList;
	private List<CodigoSituacaoTributaria> cstListEnt = new ArrayList<CodigoSituacaoTributaria>();
	private List<CodigoSituacaoTributaria> cstListSai = new ArrayList<CodigoSituacaoTributaria>();
	private String busca, filtro, tipCst, tipTrib, selecionado;
	private Long id;
	private boolean sal = true, alt = true, rem = true, tipTri = true,
			chkIcm = true, chkIpi = true, chkPisCofins = true;
	
	public String getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}

	public CodigoSituacaoTributaria getCstTeste() {
		return cstTeste;
	}

	public void setCstTeste(CodigoSituacaoTributaria cstTeste) {
		this.cstTeste = cstTeste;
	}

	public boolean isChkIcm() {
		return chkIcm;
	}

	public void setChkIcm(boolean chkIcm) {
		this.chkIcm = chkIcm;
	}

	public boolean isChkIpi() {
		return chkIpi;
	}

	public void setChkIpi(boolean chkIpi) {
		this.chkIpi = chkIpi;
	}

	public boolean isChkPisCofins() {
		return chkPisCofins;
	}

	public void setChkPisCofins(boolean chkPisCofins) {
		this.chkPisCofins = chkPisCofins;
	}

	public void setCst(CodigoSituacaoTributaria cst) {
		this.cst = cst;
	}

	public List<CodigoSituacaoTributaria> getCstList() {
		return cstList;
	}

	public void setCstList(List<CodigoSituacaoTributaria> cstList) {
		this.cstList = cstList;
	}

	public List<CodigoSituacaoTributaria> getCstListEnt() {
		return cstListEnt;
	}

	public void setCstListEnt(List<CodigoSituacaoTributaria> cstListEnt) {
		this.cstListEnt = cstListEnt;
	}

	public List<CodigoSituacaoTributaria> getCstListSai() {
		return cstListSai;
	}

	public void setCstListSai(List<CodigoSituacaoTributaria> cstListSai) {
		this.cstListSai = cstListSai;
	}

	public List<CodigoSituacaoTributaria> getCst() {
		return cstList;
	}

	public void setCst(List<CodigoSituacaoTributaria> cstList) {
		this.cstList = cstList;
	}

	public boolean isTipTri() {
		return tipTri;
	}

	public void setTipTri(boolean tipTri) {
		this.tipTri = tipTri;
	}

	public String getTipTrib() {
		return tipTrib;
	}

	public void setTipTrib(String tipTrib) {
		this.tipTrib = tipTrib;
	}

	public String getTipCst() {
		return tipCst;
	}

	public void setTipCst(String tipCst) {
		this.tipCst = tipCst;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Aliquota> getAliqList() {
		return aliqList;
	}

	public void setAliqList(List<Aliquota> aliqList) {
		this.aliqList = aliqList;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
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

	public Aliquota getAliquota() {
		return aliquota;
	}

	public void setAliquota(Aliquota aliquota) {
		this.aliquota = aliquota;
	}

	public void novo() {

	}

	public void salvar() {

	}

	public void alterar() {
		CodigoSituacaoTributariaRN cstRN = new CodigoSituacaoTributariaRN();
		cstRN.teste(cst);
	}

	public void remover() {

	}

	public void consultar() {

	}

	public void cancelar() {

	}

	public void buscaAliq() {

	}

	public void editAliq() {

	}

	public void eventTipoCst() {
		CodigoSituacaoTributariaRN cstRN = new CodigoSituacaoTributariaRN();
		this.cstList = new ArrayList<CodigoSituacaoTributaria>();
		this.cstListEnt = new ArrayList<CodigoSituacaoTributaria>();
		this.cstListSai = new ArrayList<CodigoSituacaoTributaria>();
		if (tipCst.equals("icms")) {
			this.tipTri = false;
			this.chkIcm = false;
			this.chkIpi = true;
			this.chkPisCofins = true;
			this.cstList = cstRN.cstListaIcms();
		} else if (tipCst.equals("ipi")) {
			this.tipTri = true;
			this.chkIcm = true;
			this.chkIpi = false;
			this.chkPisCofins = true;
			this.cstListEnt = cstRN.cstListaOut(TipoCst.IPI, IO.ENTRADA);
			this.cstListSai = cstRN.cstListaOut(TipoCst.IPI, IO.SAIDA);
		} else if (tipCst.equals("pisCofins")) {
			this.tipTri = true;
			this.chkIcm = true;
			this.chkIpi = true;
			this.chkPisCofins = false;
			this.cstListEnt = cstRN.cstListaOut(TipoCst.PISCOFINS, IO.ENTRADA);
			this.cstListSai = cstRN.cstListaOut(TipoCst.PISCOFINS, IO.SAIDA);
		}
	}
	
	public void filtra(){
		CodigoSituacaoTributariaRN cstRN = new CodigoSituacaoTributariaRN();
		cstRN.teste(cst);
	}
}
