package br.com.softwareOptimus.fiscal.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;
import br.com.softwareOptimus.fiscal.RN.PautaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "gradeTributariaBean")
@ViewScoped
public class GradeTributariaBean extends FacesUtil implements Serializable {

	private static final long serialVersionUID = -1841419801185722787L;
	private GradeTributaria grade;
	private GradeTributariaVigencia gradeVig;
	private List<GradeTributaria> listaGrade;
	private List<GradeTributariaVigencia> listaGradeVig;
	private List<Aliquota> listaAliquota;
	private List<Pauta> listaPauta;
	private AliquotaRN aliqRN;
	private PautaRN pautaRN;
	private GradeTributariaRN gradeRN;
	private String busca, filtro, tipoEntSai, tipoGrade;
	private Long id, idGradeVig;
	private boolean sal = true, alt = true, rem = true, vig = true,
			desc = true;

	public GradeTributariaBean() {
		setListaAliquota(this.getAliqRN().listaAliqIcms());
		setListaPauta(this.getPautaRN().consPautVig());
	}

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(true);
		setListaAliquota(this.getAliqRN().listaAliqIcms());
		setListaPauta(this.getPautaRN().consPautVig());
		limpar();
		habilita();
	}

	public void salvar() {
		try {
			this.getGrade().setIdGradeTrib(null);
			Integer retorno = this.getGradeRN().validaCampoNulo(this.getGrade());
			if (retorno == 0) {
				this.getGradeRN().salvar(this.getGrade());
				this.info("Grade salva com sucesso");
				this.setSal(true);
				this.setAlt(true);
				this.setRem(true);
				this.setVig(false);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Grade " + e.getMessage());
		}
	}

	public void alterar() {
		try {
			Integer retorno = this.getGradeRN().validaCampoNulo(this.getGrade());
			if (retorno == 0) {
				this.getGradeRN().altGrade(this.getGrade());
				this.info("Grade alterada com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração da Grade " + e.getMessage());
		}
	}

	public void remover() {
		try {
			Integer retorno = this.getGradeRN().verificaRemocao(getGrade());
			if (retorno == 0) {
				this.getGradeRN().remover(this.getGrade());
				this.info("Grade removida com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem Figuras vinculadas a esta grade. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção da Grade " + e.getMessage());
		}
	}

	public void buscarGrade() {
		limpar();
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("id")) {
				this.setListaGrade(this.getGradeRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("desc")) {
				this.setListaGrade(this.getGradeRN().consultaDesc(this.getBusca()));
			}
		} else {
			this.setListaGrade(this.getGradeRN().listar());
		}
	}

	public void editGrade() {
		this.setGrade(this.getGradeRN().editGrade(this.getId()));
		listaVigencia();
		habilita();
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		this.setVig(false);
	}

	public void limpar() {
		this.setGrade(null);
		this.setGradeVig(null);
		this.setListaGrade(null);
		this.setListaGradeVig(null);
	}

	public void cancelar() {
		this.setSal(true);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(true);
		limpar();
		desabilita();
	}

	public void excluirGradeVig() {
		try {
			this.getGradeRN().removerVig(this.getIdGradeVig());
			listaVigencia();
			this.info("Vigência da Grade removida com sucesso");
		} catch (Exception e) {
			this.error("Problemas na remoção da vigência da Grade " + e.getMessage());
		}
	}

	public void incluirGradeVig() {
		try {
			this.getGradeVig().setId(null);
			this.getGradeVig().setGrade(this.getGrade());
			if (this.getTipoEntSai().equals(IO.ENTRADA.toString())) {
				this.getGradeVig().setIo(IO.ENTRADA);
			} else if (this.getTipoEntSai().equals(IO.SAIDA.toString())) {
				this.getGradeVig().setIo(IO.SAIDA);
			}
			if (this.getTipoGrade().equals(TipoPessoaJuridica.DISTRIBUIDOR.toString())) {
				this.getGradeVig().setTipoGrade(TipoPessoaJuridica.DISTRIBUIDOR);
			} else if (this.getTipoGrade().equals(TipoPessoaJuridica.FABRICANTE.toString())) {
				this.getGradeVig().setTipoGrade(TipoPessoaJuridica.FABRICANTE);
			} else if (this.getTipoGrade().equals(TipoPessoaJuridica.OUTROS.toString())) {
				this.getGradeVig().setTipoGrade(TipoPessoaJuridica.OUTROS);
			}
			List<GradeTributariaVigencia> gradeValida = this.getGradeRN().validaInclusao(
					this.getGradeVig().getOrigem(), this.getGradeVig().getDestino(),
					this.getGradeVig().getAliquota(), this.getGradeVig().getIo(),
					this.getGradeVig().getTipoGrade(), this.getGradeVig().getVigencia(),
					this.getGradeVig().getPauta());
			if (gradeValida.size() == 0) {
				Integer retorno = this.getGradeRN().validaCampoNuloVig(this.getGradeVig());
				if (retorno == 0) {
					this.getGradeRN().salvaVig(this.getGradeVig());
					listaVigencia();
					this.info("Vigência salva com sucesso");
					this.setGradeVig(null);
					this.setTipoEntSai(new String());
					this.setTipoGrade(new String());
				} else {
					this.error("Existem campos nulos no formulário");
				}
			} else {
				this.error("Já existe uma Grade com estas caracteristicas Código: "	+ gradeValida.get(0).getGrade().getIdGradeTrib()
										+ " Descrição: " + gradeValida.get(0).getGrade().getDescricao());
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Vigência " + e.getMessage());
		}
	}

	public void listaVigencia() {
		try {
			this.getListaGradeVig().clear();
			this.setListaGradeVig(this.getGradeRN().listarVig(this.getGrade()));
		} catch (Exception e) {
			this.error("Problemas ao listar as Vigências " + e.getMessage());
		}
	}

	public void habilita() {
		this.setDesc(false);
	}

	public void desabilita() {
		this.setDesc(true);
	}

	public List<Pauta> getListaPauta() {
		if(this.listaPauta == null){
			this.listaPauta = new ArrayList<Pauta>();
		}
		return listaPauta;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public void setListaPauta(List<Pauta> listaPauta) {
		this.listaPauta = listaPauta;
	}

	public List<Aliquota> getListaAliquota() {
		if(this.listaAliquota == null){
			this.listaAliquota = new ArrayList<Aliquota>();
		}
		return listaAliquota;
	}

	public void setListaAliquota(List<Aliquota> listaAliquota) {
		this.listaAliquota = listaAliquota;
	}

	public String getTipoGrade() {
		if(this.tipoGrade == null){
			this.tipoGrade = new String();
		}
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
		if(this.gradeVig == null){
			this.gradeVig = new GradeTributariaVigencia();
		}
		return gradeVig;
	}

	public void setGradeVig(GradeTributariaVigencia gradeVig) {
		this.gradeVig = gradeVig;
	}

	public String getTipoEntSai() {
		if(this.tipoEntSai == null){
			this.tipoEntSai = new String();
		}
		return tipoEntSai;
	}

	public void setTipoEntSai(String tipoEntSai) {
		this.tipoEntSai = tipoEntSai;
	}

	public GradeTributaria getGrade() {
		if(this.grade == null){
			this.grade = new GradeTributaria();
		}
		return grade;
	}

	public void setGrade(GradeTributaria grade) {
		if(this.grade == null){
			this.grade = new GradeTributaria();
		}
		this.grade = grade;
	}

	public List<GradeTributariaVigencia> getListaGradeVig() {
		if(this.listaGradeVig == null){
			this.listaGradeVig = new ArrayList<GradeTributariaVigencia>();
		}
		return listaGradeVig;
	}

	public void setListaGradeVig(List<GradeTributariaVigencia> listaGradeVig) {
		this.listaGradeVig = listaGradeVig;
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

	public AliquotaRN getAliqRN() {
		if(this.aliqRN == null){
			this.aliqRN = new AliquotaRN();
		}
		return aliqRN;
	}

	public void setAliqRN(AliquotaRN aliqRN) {
		this.aliqRN = aliqRN;
	}

	public PautaRN getPautaRN() {
		if(this.pautaRN == null){
			this.pautaRN = new PautaRN();
		}
		return pautaRN;
	}

	public void setPautaRN(PautaRN pautaRN) {
		this.pautaRN = pautaRN;
	}

	public GradeTributariaRN getGradeRN() {
		if(this.gradeRN == null){
			this.gradeRN = new GradeTributariaRN();
		}
		return gradeRN;
	}

	public void setGradRN(GradeTributariaRN gradeRN) {
		this.gradeRN = gradeRN;
	}
}
