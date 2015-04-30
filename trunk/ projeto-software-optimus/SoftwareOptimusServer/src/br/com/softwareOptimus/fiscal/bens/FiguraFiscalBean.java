package br.com.softwareOptimus.fiscal.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.RN.FiguraFiscalRN;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "figuraFiscalBean")
@ViewScoped
public class FiguraFiscalBean extends FacesUtil implements Serializable {

	private static final long serialVersionUID = -1736356682286724886L;
	private FiguraFiscal figura = new FiguraFiscal();
	private GradeTributaria grade = new GradeTributaria();
	private List<FiguraFiscal> listaFigura = new ArrayList<FiguraFiscal>();
	private List<GradeTributaria> listaGrade = new ArrayList<GradeTributaria>();
	private List<GradeTributaria> listaGradeVis = new ArrayList<GradeTributaria>();
	private GradeTributariaRN gradRN = new GradeTributariaRN();
	private Boolean sal = true, alt = true, rem = true, vincGrade = true,
			desc = true;
	private String busca, filtro;
	private Long id, idGrade;

	public FiguraFiscalBean() {
		setListaGradeVis(this.gradRN.consGradVig());
	}

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.vincGrade = false;
		setListaGradeVis(this.gradRN.consGradVig());
		limpar();
		habilita();
	}

	public void salvar() {
		try {
			FiguraFiscalRN figuraRN = new FiguraFiscalRN();
			this.figura.setIdFigura(null);
			Integer retorno = figuraRN.validaCampoNulo(this.figura,
					this.listaGrade);
			if (retorno == 0) {
				this.figura.setGrades(this.listaGrade);
				figuraRN.salvar(this.figura);
				this.info("Figura Fiscal salva com sucesso");
				this.vincGrade = false;
				this.sal = true;
				this.alt = false;
				this.rem = false;
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Figura Fiscal " + e.getMessage());
		}
	}

	public void alterar() {
		try {
			FiguraFiscalRN figuraRN = new FiguraFiscalRN();
			Integer retorno = figuraRN.validaCampoNulo(this.figura,
					this.listaGrade);
			if (retorno == 0) {
				this.figura.setGrades(this.listaGrade);
				figuraRN.altFigura(this.figura);
				this.info("Figura Fiscal alterada com sucesso");
				this.alt = true;
				this.rem = true;
				this.vincGrade = true;
				this.sal = true;
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração da Figura Fiscal " + e.getMessage());
		}
	}

	public void remover() {
		try {
			FiguraFiscalRN figuraRN = new FiguraFiscalRN();
			Integer retorno = figuraRN.verificaRemocao(this.figura);
			if (retorno == 0) {
				figuraRN.remover(this.figura);
				this.info("Figura Fiscal removida com sucesso");
				this.alt = true;
				this.rem = true;
				this.vincGrade = true;
				this.sal = true;
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem Produtos vinculados a esta Figura. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção da Figura Fiscal " + e.getMessage());
		}
	}

	public void limpar() {
		this.figura = new FiguraFiscal();
		this.grade = new GradeTributaria();
		this.listaFigura = new ArrayList<FiguraFiscal>();
		this.listaGrade = new ArrayList<GradeTributaria>();
	}

	public void cancelar() {
		this.sal = true;
		this.alt = true;
		this.rem = true;
		this.vincGrade = true;
		limpar();
		desabilita();
	}

	public void editFigura() {
		FiguraFiscalRN figuraRN = new FiguraFiscalRN();
		this.listaGrade = new ArrayList<GradeTributaria>();
		this.figura = figuraRN.editFigura(this.id);
		this.listaGrade.addAll(this.figura.getGrades());
		habilita();
		this.sal = true;
		this.alt = false;
		this.vincGrade = false;
		this.rem = false;
	}

	public void excluirGrade() {
		List<GradeTributaria> listaGradeNova = new ArrayList<GradeTributaria>();
		listaGradeNova.addAll(this.listaGrade);
		for (GradeTributaria gra : this.listaGrade) {
			if (gra.getIdGradeTrib().equals(this.idGrade)) {
				listaGradeNova.remove(gra);
			}
		}
		this.listaGrade = new ArrayList<GradeTributaria>();
		this.listaGrade.addAll(listaGradeNova);
	}

	public void buscar() {
		limpar();
		FiguraFiscalRN figuraRN = new FiguraFiscalRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaFigura = figuraRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("des")) {
				this.listaFigura = figuraRN.consultaDesc(busca);
			}
		} else {
			this.listaFigura = figuraRN.listar();
		}
	}

	public void incluirGrade() {
		if (this.grade != null) {
			Integer retorno = verificaInclusaoGrade();
			if (retorno == 0) {
				this.listaGrade.add(this.grade);
			} else {
				this.error("Grade já vinculada na figura!");
			}
		} else {
			this.error("Escolha uma grade para incluir.");
		}
	}

	public Integer verificaInclusaoGrade() {
		Integer retorno = 0;
		for (GradeTributaria gra : this.listaGrade) {
			if (gra.getIdGradeTrib().equals(this.grade.getIdGradeTrib()))
				retorno++;
		}
		return retorno;
	}

	public void habilita() {
		this.desc = false;
	}

	public void desabilita() {
		this.desc = true;
	}

	public Boolean getDesc() {
		return desc;
	}

	public void setDesc(Boolean desc) {
		this.desc = desc;
	}

	public List<GradeTributaria> getListaGradeVis() {
		return listaGradeVis;
	}

	public void setListaGradeVis(List<GradeTributaria> listaGradeVis) {
		this.listaGradeVis = listaGradeVis;
	}

	public GradeTributaria getGrade() {
		return grade;
	}

	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}

	public Long getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(Long idGrade) {
		this.idGrade = idGrade;
	}

	public List<GradeTributaria> getListaGrade() {
		return listaGrade;
	}

	public void setListaGrade(List<GradeTributaria> listaGrade) {
		this.listaGrade = listaGrade;
	}

	public Boolean getVincGrade() {
		return vincGrade;
	}

	public void setVincGrade(Boolean vincGrade) {
		this.vincGrade = vincGrade;
	}

	public FiguraFiscal getFigura() {
		return figura;
	}

	public void setFigura(FiguraFiscal figura) {
		this.figura = figura;
	}

	public Boolean getSal() {
		return sal;
	}

	public void setSal(Boolean sal) {
		this.sal = sal;
	}

	public Boolean getAlt() {
		return alt;
	}

	public void setAlt(Boolean alt) {
		this.alt = alt;
	}

	public Boolean getRem() {
		return rem;
	}

	public void setRem(Boolean rem) {
		this.rem = rem;
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

	public List<FiguraFiscal> getListaFigura() {
		return listaFigura;
	}

	public void setListaFigura(List<FiguraFiscal> listaFigura) {
		this.listaFigura = listaFigura;
	}
}
