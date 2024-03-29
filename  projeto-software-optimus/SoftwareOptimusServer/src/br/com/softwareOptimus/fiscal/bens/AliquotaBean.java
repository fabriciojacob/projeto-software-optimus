package br.com.softwareOptimus.fiscal.bens;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;
import br.com.softwareOptimus.fiscal.TipoTrib;
import br.com.softwareOptimus.fiscal.RN.CodigoSituacaoTributariaRN;

@ManagedBean(name = "aliquotaBean")
@ViewScoped
public class AliquotaBean extends AliquotaBeanAbstract implements Serializable{

	private static final long serialVersionUID = 4885878609265619359L;

	public void novo() {
		this.setSal(false);
		this.setVinculo(false);
		this.setRem(true);
		this.setAlt(true);
		habilita();
		limpa();
	}

	public void salvar() {
		try {
			this.setColCst(null);
			this.getColCst();
			this.getAliquota().setIdAliq(null);
			if (this.getTipCst().equals("ICMS")) {
				if (this.getCst() != null) {
					this.getColCst().add(this.getCst());
				}
				this.getAliquota().setCst(this.getColCst());
				if (this.getTipTrib().equals(TipoTrib.ISENTO.toString())) {
					this.getAliquota().setTipo(TipoTrib.ISENTO);
				} else if (this.getTipTrib().equals(TipoTrib.NTRIB.toString())) {
					this.getAliquota().setTipo(TipoTrib.NTRIB);
				} else if (this.getTipTrib().equals(TipoTrib.SUBSTITUICAO.toString())) {
					this.getAliquota().setTipo(TipoTrib.SUBSTITUICAO);
				} else if (this.getTipTrib().equals(TipoTrib.TRIBUTADO.toString())) {
					this.getAliquota().setTipo(TipoTrib.TRIBUTADO);
				}
			} else if (this.getTipCst().equals("PISCOFINS") || this.getTipCst().equals("IPI")) {
				if (this.getCstEnt() != null && this.getCstSai() != null) {
					this.getColCst().add(this.getCstEnt());
					this.getColCst().add(this.getCstSai());
				}
				this.getAliquota().setCst(this.getColCst());
			}
			Integer retorno = this.getAliqRN().validaCampoNulo(this.getAliquota(),this.getColCst(), this.getTipTrib(), this.getTipCst());
			if (retorno == 0) {
				this.getAliqRN().salva(this.getAliquota());
				this.info("Al�quota salva com sucesso");
				this.setSal(true);
				this.setVinculo(true);
				this.limpa();
				this.desabilita();
			} else {
				this.error("Existem campos nulos no formul�rio");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.error("Problemas na gravacao da Al�quota " + e.getMessage());
		}
	}

	public void alterar() {
		try {
			if (this.getTipCst().equals(this.getTipCstFixo())) {
				this.getAliquota().setCst(null);
				this.setColCst(null);
				this.getColCst();
				if (this.getTipCst().equals(TipoCst.ICMS.toString())) {
					if (this.getTipTrib().equals(TipoTrib.ISENTO.toString())) {
						this.getAliquota().setTipo(TipoTrib.ISENTO);
					} else if (this.getTipTrib().equals(TipoTrib.NTRIB.toString())) {
						this.getAliquota().setTipo(TipoTrib.NTRIB);
					} else if (this.getTipTrib().equals(TipoTrib.SUBSTITUICAO.toString())) {
						this.getAliquota().setTipo(TipoTrib.SUBSTITUICAO);
					} else if (this.getTipTrib().equals(TipoTrib.TRIBUTADO.toString())) {
						this.getAliquota().setTipo(TipoTrib.TRIBUTADO);
					}
					if (this.getCst() != null) {
						this.getColCst().add(this.getCst());
					}
					this.getAliquota().setCst(this.getColCst());
				} else {
					this.getAliquota().setTipo(null);
					if (this.getCstEnt() != null && this.getCstSai() != null) {
						this.getColCst().add(this.getCstEnt());
						this.getColCst().add(this.getCstSai());
					}
					this.getAliquota().setCst(this.getColCst());
				}
				Integer retorno = this.getAliqRN().validaCampoNulo(this.getAliquota(),this.getColCst(), this.getTipTrib(), this.getTipCst());
				if (retorno == 0) {
					this.getAliqRN().altAliq(this.getAliquota());
					this.info("Al�quota alterada com sucesso");
					this.setAlt(true);
					this.setRem(true);
					this.setVinculo(true);
					limpa();
					desabilita();
				} else {
					this.error("Existem campos nulos no formul�rio");
				}
			} else {
				this.error("Altera��o de Cst n�o permitida. Vincule o tipo de Cst correto para a al�quota que se deseja alterar ou cadastre outra.");
			}
		} catch (Exception e) {
			this.error("Problemas na altera��o da Al�quota " + e.getMessage());
		}
	}

	public void remover() {
		try {
			Integer retorno = this.getAliqRN().ValidaRemocao(this.getAliquota());
			if (retorno == 0) {
				this.getAliqRN().remove(this.getAliquota().getIdAliq());
				this.info("Al�quota removida com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVinculo(true);
				limpa();
				desabilita();
			} else {
				this.error("Remo��o n�o permitida! Existem registros vinculados a esta al�quota. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remo��o da Al�quota " + e.getMessage());
		}
	}

	public void cancelar() {
		this.setSal(true);
		this.setAlt(true);
		this.setRem(true);
		this.setVinculo(true);
		limpa();
		desabilita();
	}

	public void aliquotaSelecionado(SelectEvent event){
		Aliquota ali;
		try {
			ali = (Aliquota) event.getObject();
			this.setAliquota(this.getAliqRN().editAliq(ali.getIdAliq()));
		} catch (Exception e) {
			this.error("Problemas na edi��o"+ e.getMessage());
			ali = new Aliquota();
		}
		this.setTipCstFixo("");
		CodigoSituacaoTributariaRN cstRN = new CodigoSituacaoTributariaRN();
		this.setColCst(this.getAliquota().getCst());
		if (this.getAliquota().getTipo() != null) {
			for (CodigoSituacaoTributaria Cst : this.getColCst()) {
				this.setCst(Cst);
			}
			if (this.getAliquota().getTipo().equals(TipoTrib.ISENTO)) {
				this.setTipTrib(TipoTrib.ISENTO.toString());
			} else if (this.getAliquota().getTipo().equals(TipoTrib.NTRIB)) {
				this.setTipTrib(TipoTrib.NTRIB.toString());
			} else if (this.getAliquota().getTipo().equals(TipoTrib.SUBSTITUICAO)) {
				this.setTipTrib(TipoTrib.SUBSTITUICAO.toString());
			} else if (this.getAliquota().getTipo().equals(TipoTrib.TRIBUTADO)) {
				this.setTipTrib(TipoTrib.TRIBUTADO.toString());
			}
			this.setTipCst(TipoCst.ICMS.toString());
			this.setCstList(cstRN.cstListaIcms());
			this.setChkIcm(false);
			this.setTipTri(false);
			this.setChkIpi(true);
			this.setChkPisCofins(true);
		} else {
			this.setTipTrib(null);
			for (CodigoSituacaoTributaria Cst : this.getColCst()) {
				if (Cst.getIo().equals(IO.ENTRADA)) {
					this.setCstEnt(Cst);
				} else {
					this.setCstSai(Cst);
				}
			}
			if (this.getCstEnt().getTipoCst().equals(TipoCst.PISCOFINS)) {
				this.setChkIcm(true);
				this.setTipTri(true);
				this.setChkIpi(true);
				this.setChkPisCofins(false);
				this.setCstListEnt(cstRN.cstListaOut(TipoCst.PISCOFINS,IO.ENTRADA));
				this.setCstListSai(cstRN.cstListaOut(TipoCst.PISCOFINS, IO.SAIDA));
				this.setTipCst(TipoCst.PISCOFINS.toString());
			} else {
				this.setChkIcm(true);
				this.setTipTri(true);
				this.setChkIpi(false);
				this.setChkPisCofins(true);
				this.setCstListEnt(cstRN.cstListaOut(TipoCst.IPI, IO.ENTRADA));
				this.setCstListSai(cstRN.cstListaOut(TipoCst.IPI, IO.SAIDA));
				this.setTipCst(TipoCst.IPI.toString());
			}
		}
		this.setTipCstFixo(this.getTipCst());
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		this.setVinculo(false);
		habilita();
	}

	public void editAliq() {
		
	}

	public void eventTipoCst() {
		CodigoSituacaoTributariaRN cstRN = new CodigoSituacaoTributariaRN();
		if (this.getTipCst().equals("ICMS")) {
			this.setTipTri(false);
			this.setChkIcm(false);
			this.setChkIpi(true);
			this.setChkPisCofins(true);
			this.setCstList(cstRN.cstListaIcms());
		} else if (this.getTipCst().equals("IPI")) {
			this.setTipTri(true);
			this.setChkIcm(true);
			this.setChkIpi(false);
			this.setChkPisCofins(true);
			this.setCstListEnt(cstRN.cstListaOut(TipoCst.IPI, IO.ENTRADA));
			this.setCstListSai(cstRN.cstListaOut(TipoCst.IPI, IO.SAIDA));
		} else if (this.getTipCst().equals("PISCOFINS")) {
			this.setTipTri(true);
			this.setChkIcm(true);
			this.setChkIpi(true);
			this.setChkPisCofins(false);
			this.setCstListEnt(cstRN.cstListaOut(TipoCst.PISCOFINS, IO.ENTRADA));
			this.setCstListSai(cstRN.cstListaOut(TipoCst.PISCOFINS, IO.SAIDA));
		}
	}

	public void limpa() {
		this.setTipCst(null);
		this.setTipTrib(null);
		this.setChkIcm(true);
		this.setChkIpi(true);
		this.setChkPisCofins(true);
		this.setTipTri(true);
		this.setAliquota(null);
		this.setCst(null);
		this.setCstEnt(null);
		this.setCstSai(null);
		this.setCstList(null);
		this.setCstListEnt(null);
		this.setCstListSai(null);
		this.setAliqList(null);
		this.setColCst(null);
	}

	public void habilita() {
		this.setAliq(false);
		this.setRed(false);
	}

	public void desabilita() {
		this.setAliq(true);
		this.setRed(true);
	}

}
