package br.com.softwareOptimus.produto.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.produto.RN.GrupoRN;
import br.com.softwareOptimus.produto.RN.SubGrupoRN;

@ManagedBean(name = "grupoBean")
@ViewScoped
public class GrupoBean {

	private Grupo grupo = new Grupo();
	private SubGrupo subGrupo = new SubGrupo();
	private List<Grupo> listaGrupo = new ArrayList<Grupo>();
	private List<SubGrupo> listaSubGrupo = new ArrayList<SubGrupo>();
	private List<SubGrupo> listaSubGrupoExib = new ArrayList<SubGrupo>();
	private SubGrupoRN subRN = new SubGrupoRN();
	private String busca, filtro;
	private boolean sal = true, alt = true, rem = true, desc = true,
			vig = true;
	private Long id, idSub;

	public GrupoBean() {
		this.listaSubGrupo = this.subRN.listaSubGrupo();
	}

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.vig = false;
		this.listaSubGrupo = this.subRN.listaSubGrupo();
		limpar();
		habilita();
	}

	public void salvar() {
		try {
			GrupoRN gruRN = new GrupoRN();
			this.grupo.setIdGrupo(null);
			
			Integer retorno = gruRN.validaCampoNulo(this.grupo, this.listaSubGrupoExib);
			if (retorno == 0) {
				this.grupo.setSubGrupo(this.listaSubGrupoExib);
				gruRN.salvar(this.grupo);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Grupo salvo com sucesso"));
				this.vig = false;
				this.sal = true;
				this.alt = false;
				this.rem = false;
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
									"Info", "Problemas na gravacao do Grupo "
											+ e.getMessage()));
		}
	}

	public void alterar() {
		try {
			GrupoRN gruRN = new GrupoRN();
			Integer retorno = gruRN.validaCampoNulo(this.grupo, this.listaSubGrupoExib);
			if (retorno == 0) {
				this.grupo.setSubGrupo(this.listaSubGrupoExib);
				gruRN.altGru(this.grupo);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Grupo alterado com sucesso"));
				this.alt = true;
				this.rem = true;
				this.vig = true;
				this.sal = true;
				limpar();
				desabilita();
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
									"Info", "Problemas na alteração do Grupo "
											+ e.getMessage()));
		}
	}

	public void remover() {
		try {
			GrupoRN gruRN = new GrupoRN();
			Integer retorno = gruRN.verificaRemocao(this.grupo);
			if (retorno == 0) {
				gruRN.remover(this.grupo);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Grupo removido com sucesso"));
				this.alt = true;
				this.rem = true;
				this.vig = true;
				limpar();
				desabilita();
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
										"Info",
										"Remoção não permitida! Existem Setores vinculados a este Grupo. "));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção do Grupo " + e.getMessage()));
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

	public void limpar() {
		this.grupo = new Grupo();
		this.subGrupo = new SubGrupo();
		this.listaGrupo = new ArrayList<Grupo>();
		this.listaSubGrupoExib = new ArrayList<SubGrupo>();
	}

	public void buscarGrup() {
		limpar();
		GrupoRN gruRN = new GrupoRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaGrupo = gruRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.listaGrupo = gruRN.consultaDesc(busca);
			}
		} else {
			this.listaGrupo = gruRN.listar();
		}
	}

	public void removiSub() {
		List<SubGrupo> listaSubNovo = new ArrayList<SubGrupo>();
		listaSubNovo.addAll(this.listaSubGrupoExib);
		for (SubGrupo sub : this.listaSubGrupoExib) {
			if (sub.getIdSubGrupo().equals(this.idSub)){
				listaSubNovo.remove(sub);
			}
		}
		this.listaSubGrupoExib = new ArrayList<SubGrupo>();
		this.listaSubGrupoExib.addAll(listaSubNovo);
	}

	public void editGrupo() {
		limpar();
		GrupoRN gruRN = new GrupoRN();
		this.grupo = gruRN.editGru(this.id);
		this.listaSubGrupoExib.addAll(this.subRN.listaSubGru(this.id));
		habilita();
		this.alt = false;
		this.vig = false;
		this.rem = false;
		this.sal = true;
	}

	public void incluirSub() {
		if (this.subGrupo != null) {
			Integer retorno = verificaInclusaoSubGrupo();
			if (retorno == 0) {
				this.listaSubGrupoExib.add(this.subGrupo);
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"SubGrupo já vinculado no Grupo!"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Escolha uma SubGrupo para incluir."));
		}
	}

	private Integer verificaInclusaoSubGrupo() {
		Integer retorno = 0;
		for (SubGrupo sub : this.listaSubGrupoExib) {
			if (sub.getIdSubGrupo().equals(this.subGrupo.getIdSubGrupo()))
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

	public List<SubGrupo> getListaSubGrupoExib() {
		return listaSubGrupoExib;
	}

	public void setListaSubGrupoExib(List<SubGrupo> listaSubGrupoExib) {
		this.listaSubGrupoExib = listaSubGrupoExib;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public SubGrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
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

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public boolean isVig() {
		return vig;
	}

	public void setVig(boolean vig) {
		this.vig = vig;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSub() {
		return idSub;
	}

	public void setIdSub(Long idSub) {
		this.idSub = idSub;
	}
}
