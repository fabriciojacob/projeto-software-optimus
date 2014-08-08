package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;
import br.com.softwareOptimus.fiscal.TipoTrib;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.fiscal.RN.CodigoSituacaoTributariaRN;

@ManagedBean(name = "aliquotaBean")
@SessionScoped
public class AliquotaBean {

	private Aliquota aliquota = new Aliquota();
	private CodigoSituacaoTributaria cst = new CodigoSituacaoTributaria();
	private CodigoSituacaoTributaria cstEnt = new CodigoSituacaoTributaria();
	private CodigoSituacaoTributaria cstSai = new CodigoSituacaoTributaria();
	private Collection<CodigoSituacaoTributaria> colCst = new ArrayList<CodigoSituacaoTributaria>();
	private List<CodigoSituacaoTributaria> cstList;
	private List<CodigoSituacaoTributaria> cstListEnt;
	private List<CodigoSituacaoTributaria> cstListSai;
	private List<Aliquota> aliqList = new ArrayList<Aliquota>();
	private String busca, filtro, tipCst, tipTrib;
	private Long id;
	private boolean sal = true, alt = true, rem = true, tipTri = true,
			vinculo = true, chkIcm = true, chkIpi = true, chkPisCofins = true;

	public boolean isVinculo() {
		return vinculo;
	}

	public void setVinculo(boolean vinculo) {
		this.vinculo = vinculo;
	}

	public CodigoSituacaoTributaria getCstEnt() {
		return cstEnt;
	}

	public void setCstEnt(CodigoSituacaoTributaria cstEnt) {
		this.cstEnt = cstEnt;
	}

	public CodigoSituacaoTributaria getCstSai() {
		return cstSai;
	}

	public void setCstSai(CodigoSituacaoTributaria cstSai) {
		this.cstSai = cstSai;
	}

	public CodigoSituacaoTributaria getCst() {
		return cst;
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
		this.sal = false;
		this.vinculo = false;
		this.alt = true;
		this.rem = true;
		limpa();
	}

	public void salvar() {
		try {
			AliquotaRN aliqRN = new AliquotaRN();
			this.aliquota.setIdAliq(null);
			if (tipCst.equals("icms")) {
				this.colCst.add(cst);
				this.aliquota.setCst(this.colCst);
				if (this.tipTrib.equals(TipoTrib.ISENTO.toString())) {
					this.aliquota.setTipo(TipoTrib.ISENTO);
				} else if (this.tipTrib.equals(TipoTrib.NTRIB.toString())) {
					this.aliquota.setTipo(TipoTrib.NTRIB);
				} else if (this.tipTrib
						.equals(TipoTrib.SUBSTITUICAO.toString())) {
					this.aliquota.setTipo(TipoTrib.SUBSTITUICAO);
				} else if (this.tipTrib.equals(TipoTrib.TRIBUTADO.toString())) {
					this.aliquota.setTipo(TipoTrib.TRIBUTADO);
				}
			} else if (tipCst.equals("pisCofins") || tipCst.equals("ipi")) {
				this.colCst.add(cstEnt);
				this.colCst.add(cstSai);
				this.aliquota.setCst(this.colCst);
			}
			aliqRN.salva(aliquota);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Al�quota salva com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao da Al�quota "
									+ e.getMessage()));
		}
		this.sal = true;
		this.vinculo = true;
		limpa();
	}

	public void alterar() {
	}

	public void remover() {

	}

	public void cancelar() {
		this.sal = true;
		this.alt = true;
		this.rem = true;
		this.vinculo = true;
		limpa();
	}

	public void buscaAliq() {
		limpa();
		AliquotaRN aliqRN = new AliquotaRN();
		if (!busca.equals("")) {
			if (filtro.equals("id")) {
				this.aliqList = aliqRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("aliq")) {
				this.aliqList = aliqRN.consultaAliq(Double.parseDouble(busca));
			} else if (filtro.equals("red")) {
				this.aliqList = aliqRN.consultaRed(Double.parseDouble(busca));
			}
		} else {
			this.aliqList = aliqRN.lista();
		}
	}

	public void editAliq() {
		AliquotaRN aliqRN = new AliquotaRN();
		this.aliquota = aliqRN.editUnid(id);
		this.alt = false;
		this.rem = false;
		this.sal = true;
		this.vinculo = false;
	}

	public void eventTipoCst() {
		CodigoSituacaoTributariaRN cstRN = new CodigoSituacaoTributariaRN();
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

	public void limpa() {
		this.aliquota = new Aliquota();
		this.cst = new CodigoSituacaoTributaria();
		this.cstEnt = new CodigoSituacaoTributaria();
		this.cstSai = new CodigoSituacaoTributaria();
		this.cstList = new ArrayList<CodigoSituacaoTributaria>();
		this.cstListEnt = new ArrayList<CodigoSituacaoTributaria>();
		this.cstListSai = new ArrayList<CodigoSituacaoTributaria>();
		this.aliqList = new ArrayList<Aliquota>();
		this.colCst = new ArrayList<CodigoSituacaoTributaria>();
	}
}
