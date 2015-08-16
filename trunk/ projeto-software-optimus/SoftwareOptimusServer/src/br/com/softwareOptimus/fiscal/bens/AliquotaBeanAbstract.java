package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.util.FacesUtil;

public abstract class AliquotaBeanAbstract extends FacesUtil{
	
	private static final long serialVersionUID = 1L;

	public abstract void novo();
	public abstract void salvar();
	public abstract void alterar();
	public abstract void remover();
	public abstract void cancelar();
	public abstract void buscaAliq();
	public abstract void editAliq();
	public abstract void eventTipoCst();
	public abstract void limpa();
	public abstract void habilita();
	public abstract void desabilita();
	
	private Aliquota aliquota;
	private AliquotaRN aliqRN;
	private CodigoSituacaoTributaria cst;
	private CodigoSituacaoTributaria cstEnt;
	private CodigoSituacaoTributaria cstSai;
	private Collection<CodigoSituacaoTributaria> colCst;
	private List<CodigoSituacaoTributaria> cstList;
	private List<CodigoSituacaoTributaria> cstListEnt;
	private List<CodigoSituacaoTributaria> cstListSai;
	private List<Aliquota> aliqList;
	private String busca, filtro, tipCst, tipTrib, tipCstFixo;
	private Long id;
	private boolean sal = true, alt = true, rem = true, tipTri = true,
			vinculo = true, chkIcm = true, chkIpi = true, chkPisCofins = true,
			aliq = true, red = true;
	
	public boolean isAliq() {
		return aliq;
	}

	public void setAliq(boolean aliq) {
		this.aliq = aliq;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	public boolean isVinculo() {
		return vinculo;
	}

	public void setVinculo(boolean vinculo) {
		this.vinculo = vinculo;
	}

	public CodigoSituacaoTributaria getCstEnt() {
		if(this.cstEnt == null){
			this.cstEnt = new CodigoSituacaoTributaria();
		}
		return cstEnt;
	}

	public void setCstEnt(CodigoSituacaoTributaria cstEnt) {
		this.cstEnt = cstEnt;
	}

	public CodigoSituacaoTributaria getCstSai() {
		if(this.cstSai == null){
			this.cstSai = new CodigoSituacaoTributaria();
		}
		return cstSai;
	}

	public void setCstSai(CodigoSituacaoTributaria cstSai) {
		this.cstSai = cstSai;
	}

	public CodigoSituacaoTributaria getCst() {
		if(this.cst == null){
			this.cst = new CodigoSituacaoTributaria();			
		}
		return cst;
	}

	public void setCst(CodigoSituacaoTributaria cst) {
		this.cst = cst;
	}

	public List<CodigoSituacaoTributaria> getCstList() {
		if(this.cstList == null){
			this.cstList = new ArrayList<CodigoSituacaoTributaria>();
		}
		return cstList;
	}

	public void setCstList(List<CodigoSituacaoTributaria> cstList) {
		this.cstList = cstList;
	}

	public List<CodigoSituacaoTributaria> getCstListEnt() {
		if(this.cstListEnt == null){
			this.cstListEnt = new ArrayList<CodigoSituacaoTributaria>();
		}
		return cstListEnt;
	}

	public void setCstListEnt(List<CodigoSituacaoTributaria> cstListEnt) {
		this.cstListEnt = cstListEnt;
	}

	public List<CodigoSituacaoTributaria> getCstListSai() {
		if(this.cstListSai == null){
			this.cstListSai = new ArrayList<CodigoSituacaoTributaria>();
		}
		return cstListSai;
	}

	public void setCstListSai(List<CodigoSituacaoTributaria> cstListSai) {
		this.cstListSai = cstListSai;
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

	public boolean isTipTri() {
		return tipTri;
	}

	public void setTipTri(boolean tipTri) {
		this.tipTri = tipTri;
	}

	public String getTipTrib() {
		if(this.tipTrib == null){
			this.tipTrib = "";
		}
		return tipTrib;
	}

	public void setTipTrib(String tipTrib) {
		this.tipTrib = tipTrib;
	}

	public String getTipCst() {
		if(this.tipCst == null){
			this.tipCst = new String();
		}
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
		if(this.aliqList == null){
			this.aliqList = new ArrayList<Aliquota>();
		}
		return aliqList;
	}

	public void setAliqList(List<Aliquota> aliqList) {
		this.aliqList = aliqList;
	}

	public String getFiltro() {
		if(this.filtro == null){
			this.filtro = new String();
		}
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getBusca() {
		if(this.busca  == null){
			this.busca = new String();
		}
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
		if (this.aliquota == null){
			this.aliquota = new Aliquota();
		}
		return aliquota;
	}

	public void setAliquota(Aliquota aliquota) {
		this.aliquota = aliquota;
	}
	public Collection<CodigoSituacaoTributaria> getColCst() {
		if (this.colCst == null){
			this.colCst = new ArrayList<CodigoSituacaoTributaria>();			
		}
		return colCst;
	}
	public void setColCst(Collection<CodigoSituacaoTributaria> colCst) {
		this.colCst = colCst;
	}
	public String getTipCstFixo() {
		if (this.tipCstFixo == null){
			this.tipCstFixo = new String();			
		}
		return tipCstFixo;
	}
	
	public void setTipCstFixo(String tipCstFixo) {
		this.tipCstFixo = tipCstFixo;
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
}
