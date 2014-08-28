package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;
import br.com.softwareOptimus.fiscal.RN.PautaRN;

@ManagedBean(name = "gradeTributariaBean")
@ViewScoped
public class GradeTributariaBean {

	private GradeTributaria grade = new GradeTributaria();
	private GradeTributariaVigencia gradeVig = new GradeTributariaVigencia();
	private List<GradeTributaria> listaGrade = new ArrayList<GradeTributaria>();
	private List<GradeTributariaVigencia> listaGradeVig = new ArrayList<GradeTributariaVigencia>();
	private List<Aliquota> listaAliquota = new ArrayList<Aliquota>();
	private List<Pauta> listaPauta = new ArrayList<Pauta>();
	private AliquotaRN aliqRN = new AliquotaRN();
	private PautaRN pautaRN = new PautaRN();
	private String busca, filtro, tipoEntSai, tipoGrade;
	private Long id, idGradeVig;
	private boolean sal = true, alt = true, rem = true, vig = true;

	public GradeTributariaBean() {
		setListaAliquota(this.aliqRN.listaAliqIcms());
		setListaPauta(this.pautaRN.listar());
	}

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		setListaAliquota(this.aliqRN.listaAliqIcms());
		setListaPauta(this.pautaRN.listar());
		limpar();
	}

	public void salvar() {
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			this.grade.setIdGradeTrib(null);
			Integer retorno = gradeRN.validaCampoNulo(this.grade);
			if (retorno == 0) {
				gradeRN.salvar(this.grade);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Grade salva com sucesso"));
				this.vig = false;
				this.sal = true;
				this.alt = true;
				this.rem = true;
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
									"Info", "Problemas na gravacao da Grade "
											+ e.getMessage()));
		}
	}

	public void alterar() {
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			Integer retorno = gradeRN.validaCampoNulo(this.grade);
			if (retorno == 0) {
				gradeRN.altGrade(this.grade);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Grade alterada com sucesso"));
				this.alt = true;
				this.rem = true;
				this.vig = true;
				limpar();
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
									"Info", "Problemas na alteração da Grade "
											+ e.getMessage()));
		}
	}

	public void remover() {
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			gradeRN.remover(this.grade);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Grade removida com sucesso"));
			this.alt = true;
			this.rem = true;
			this.vig = true;
			limpar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção da Grade " + e.getMessage()));
		}
	}

	public void buscarGrade() {
		limpar();
		GradeTributariaRN gradeRN = new GradeTributariaRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaGrade = gradeRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.listaGrade = gradeRN.consultaDesc(busca);
			}
		} else {
			this.listaGrade = gradeRN.listar();
		}
	}

	public void editGrade() {
		GradeTributariaRN gradeRN = new GradeTributariaRN();
		this.grade = gradeRN.editPauta(id);
		listaVigencia();
		this.alt = false;
		this.vig = false;
		this.rem = false;
		this.sal = true;
	}

	public void limpar() {
		this.grade = new GradeTributaria();
		this.gradeVig = new GradeTributariaVigencia();
		this.listaGrade = new ArrayList<GradeTributaria>();
		this.listaGradeVig = new ArrayList<GradeTributariaVigencia>();
	}

	public void cancelar() {
		this.sal = true;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		limpar();
	}

	public void excluirGradeVig() {
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			gradeRN.removerVig(this.idGradeVig);
			listaVigencia();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Vigência da Grade removida com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção da vigência da Grade "
									+ e.getMessage()));
		}
	}

	public void incluirGradeVig() {
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			this.gradeVig.setId(null);
			this.gradeVig.setGrade(this.grade);
			if (this.tipoEntSai.equals(IO.ENTRADA.toString())) {
				this.gradeVig.setIo(IO.ENTRADA);
			} else if (this.tipoEntSai.equals(IO.SAIDA.toString())) {
				this.gradeVig.setIo(IO.SAIDA);
			}
			if (this.tipoGrade.equals(TipoPessoaJuridica.DISTRIBUIDOR
					.toString())) {
				this.gradeVig.setTipoGrade(TipoPessoaJuridica.DISTRIBUIDOR);
			} else if (this.tipoGrade.equals(TipoPessoaJuridica.FABRICANTE
					.toString())) {
				this.gradeVig.setTipoGrade(TipoPessoaJuridica.FABRICANTE);
			} else if (this.tipoGrade.equals(TipoPessoaJuridica.OUTROS
					.toString())) {
				this.gradeVig.setTipoGrade(TipoPessoaJuridica.OUTROS);
			}
			List<GradeTributariaVigencia> gradeValida = gradeRN.validaInclusao(
					this.gradeVig.getOrigem(), this.gradeVig.getDestino(),
					this.gradeVig.getAliquota(), this.gradeVig.getIo(),
					this.gradeVig.getTipoGrade(), this.gradeVig.getVigencia(),
					this.gradeVig.getPauta());
			if (gradeValida.size() == 0) {
				Integer retorno = gradeRN.validaCampoNuloVig(this.gradeVig);
				if (retorno == 0) {
					gradeRN.salvaVig(this.gradeVig);
					listaVigencia();
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Info", "Vigência salva com sucesso"));
					this.gradeVig = new GradeTributariaVigencia();
					this.tipoEntSai = new String();
					this.tipoGrade = new String();
				} else {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info",
									"Existem campos nulos no formulário"));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Já existe uma Grade com estas caracteristicas Código: "
										+ gradeValida.get(0).getGrade()
												.getIdGradeTrib()
										+ " Descrição: "
										+ gradeValida.get(0).getGrade()
												.getDescricao()));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao da Vigência "
									+ e.getMessage()));
		}
	}

	public void listaVigencia() {
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			if (this.listaGradeVig != null) {
				this.listaGradeVig.clear();
			}
			this.listaGradeVig = gradeRN.listarVig(this.grade);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas ao listar as Vigências "
									+ e.getMessage()));
		}

	}

	public List<Pauta> getListaPauta() {
		return listaPauta;
	}

	public void setListaPauta(List<Pauta> listaPauta) {
		this.listaPauta = listaPauta;
	}

	public List<Aliquota> getListaAliquota() {
		return listaAliquota;
	}

	public void setListaAliquota(List<Aliquota> listaAliquota) {
		this.listaAliquota = listaAliquota;
	}

	public String getTipoGrade() {
		return tipoGrade;
	}

	public void setTipoGrade(String tipoGrade) {
		this.tipoGrade = tipoGrade;
	}

	public Long getIdGradeVig() {
		return idGradeVig;
	}

	public void setIdGradeVig(Long idGradeVig) {
		this.idGradeVig = idGradeVig;
	}

	public boolean isVig() {
		return vig;
	}

	public void setVig(boolean vig) {
		this.vig = vig;
	}

	public GradeTributariaVigencia getGradeVig() {
		return gradeVig;
	}

	public void setGradeVig(GradeTributariaVigencia gradeVig) {
		this.gradeVig = gradeVig;
	}

	public String getTipoEntSai() {
		return tipoEntSai;
	}

	public void setTipoEntSai(String tipoEntSai) {
		this.tipoEntSai = tipoEntSai;
	}

	public GradeTributaria getGrade() {
		return grade;
	}

	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}

	public List<GradeTributariaVigencia> getListaGradeVig() {
		return listaGradeVig;
	}

	public void setListaGradeVig(List<GradeTributariaVigencia> listaGradeVig) {
		this.listaGradeVig = listaGradeVig;
	}

	public List<GradeTributaria> getListaGrade() {
		return listaGrade;
	}

	public void setListaGrade(List<GradeTributaria> listaGrade) {
		this.listaGrade = listaGrade;
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
}
