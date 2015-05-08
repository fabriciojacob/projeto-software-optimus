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
	private FiguraFiscal figura;
	private GradeTributaria grade;
	private List<FiguraFiscal> listaFigura;
	private List<GradeTributaria> listaGrade;
	private List<GradeTributaria> listaGradeVis;
	private GradeTributariaRN gradRN;
	private FiguraFiscalRN figuraRN;
	private Boolean sal = true, alt = true, rem = true, vincGrade = true,
			desc = true;
	private String busca, filtro;
	private Long id, idGrade;

	public FiguraFiscalBean() {
		setListaGradeVis(this.getGradRN().consGradVig());
	}

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		this.setVincGrade(false);
		setListaGradeVis(this.getGradRN().consGradVig());
		limpar();
		habilita();
	}

	public void salvar() {
		try {
			this.getFigura().setIdFigura(null);
			Integer retorno = this.getFiguraRN().validaCampoNulo(this.getFigura(),this.listaGrade);
			if (retorno == 0) {
				this.getFigura().setGrades(this.listaGrade);
				this.getFiguraRN().salvar(this.getFigura());
				this.info("Figura Fiscal salva com sucesso");
				this.setSal(true);
				this.setAlt(false);
				this.setRem(false);
				this.setVincGrade(false);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Figura Fiscal " + e.getMessage());
		}
	}

	public void alterar() {
		try {
			Integer retorno = this.getFiguraRN().validaCampoNulo(this.getFigura(),this.listaGrade);
			if (retorno == 0) {
				this.getFigura().setGrades(this.listaGrade);
				this.getFiguraRN().altFigura(this.getFigura());
				this.info("Figura Fiscal alterada com sucesso");
				this.setSal(true);
				this.setAlt(true);
				this.setRem(true);
				this.setVincGrade(true);
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
			Integer retorno = this.getFiguraRN().verificaRemocao(this.getFigura());
			if (retorno == 0) {
				this.getFiguraRN().remover(this.getFigura());
				this.info("Figura Fiscal removida com sucesso");
				this.setSal(true);
				this.setAlt(true);
				this.setRem(true);
				this.setVincGrade(true);
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
		this.setFigura(null);
		this.setGrade(null);
		this.setListaFigura(null);
		this.setListaGrade(null);
	}

	public void cancelar() {
		this.setSal(true);
		this.setAlt(true);
		this.setRem(true);
		this.setVincGrade(true);
		limpar();
		desabilita();
	}

	public void editFigura() {
		this.setListaGrade(null);
		this.setFigura(this.getFiguraRN().editFigura(this.getId()));
		this.getListaGrade().addAll(this.getFigura().getGrades());
		habilita();
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		this.setVincGrade(false);
	}

	public void excluirGrade() {
		List<GradeTributaria> listaGradeNova = new ArrayList<GradeTributaria>();
		listaGradeNova.addAll(this.getListaGrade());
		for (GradeTributaria gra : this.getListaGrade()) {
			if (gra.getIdGradeTrib().equals(this.getIdGrade())) {
				listaGradeNova.remove(gra);
			}
		}
		this.setListaGrade(null);
		this.getListaGrade().addAll(listaGradeNova);
	}

	public void buscar() {
		limpar();
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("id")) {
				this.setListaFigura(this.getFiguraRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("des")) {
				this.setListaFigura(this.getFiguraRN().consultaDesc(this.getBusca()));
			}
		} else {
			this.setListaFigura(this.getFiguraRN().listar());
		}
	}

	public void incluirGrade() {
		if (this.getGrade().getIdGradeTrib() != null) {
			Integer retorno = verificaInclusaoGrade();
			if (retorno == 0) {
				this.getListaGrade().add(this.getGrade());
			} else {
				this.error("Grade já vinculada na figura!");
			}
		} else {
			this.error("Escolha uma grade para incluir.");
		}
	}

	public Integer verificaInclusaoGrade() {
		Integer retorno = 0;
		for (GradeTributaria gra : this.getListaGrade()) {
			if (gra.getIdGradeTrib().equals(this.getGrade().getIdGradeTrib()))
				retorno++;
		}
		return retorno;
	}

	public void habilita() {
		this.setDesc(false);
	}

	public void desabilita() {
		this.setDesc(true);
	}

	public Boolean getDesc() {
		return desc;
	}

	public void setDesc(Boolean desc) {
		this.desc = desc;
	}

	public List<GradeTributaria> getListaGradeVis() {
		if(this.listaGradeVis == null){
			this.listaGradeVis = new ArrayList<GradeTributaria>();
		}
		return listaGradeVis;
	}

	public void setListaGradeVis(List<GradeTributaria> listaGradeVis) {
		this.listaGradeVis = listaGradeVis;
	}

	public GradeTributaria getGrade() {
		if(this.grade == null){
			this.grade = new GradeTributaria();
		}
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
		if(this.listaGrade == null){
			this.listaGrade = new ArrayList<GradeTributaria>();			
		}
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
		if(this.figura == null){
			this.figura = new FiguraFiscal();
		}
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
		if(this.busca == null){
			this.busca = new String();
		}
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public GradeTributariaRN getGradRN() {
		if(this.gradRN == null){
			this.gradRN = new GradeTributariaRN();
		}
		return gradRN;
	}

	public void setGradRN(GradeTributariaRN gradRN) {
		this.gradRN = gradRN;
	}

	public FiguraFiscalRN getFiguraRN() {
		if(this.figuraRN == null){
			this.figuraRN = new FiguraFiscalRN();
		}
		return figuraRN;
	}

	public void setFiguraRN(FiguraFiscalRN figuraRN) {
		this.figuraRN = figuraRN;
	}
	
	
}
