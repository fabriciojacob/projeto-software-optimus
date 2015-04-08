package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.RN.GrupoRN;
import br.com.softwareOptimus.produto.RN.SetorRN;

@ManagedBean(name = "setorBean")
@ViewScoped
public class SetorBean implements Serializable{

	private static final long serialVersionUID = -6889204545055216922L;
	private Setor setor = new Setor();
	private Grupo grupo = new Grupo();
	private List<Setor> listaSetor = new ArrayList<Setor>();
	private List<Grupo> listaGrupo = new ArrayList<Grupo>();
	private List<Grupo> listaGrupoExib = new ArrayList<Grupo>();
	private GrupoRN gruRN = new GrupoRN();
	private String busca, filtro;
	private boolean sal = true, alt = true, rem = true, desc = true,
			vig = true;
	private Long id, idGrup;

	public SetorBean() {
		this.listaGrupo = gruRN.listaGrupo();
	}

	public void novo() {
		limpar();
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.vig = false;
		this.listaGrupo = gruRN.listaGrupo();
		habilita();
	}

	public void salvar() {
		try {
			SetorRN setRN = new SetorRN();
			this.setor.setIdSetor(null);
			Integer retorno = setRN.validaCampoNulo(this.setor, this.listaGrupoExib);
			if (retorno == 0) {
				this.setor.setGrupo(this.listaGrupoExib);
				setRN.salvar(this.setor);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Setor salvo com sucesso"));
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
									"Info", "Problemas na gravacao do Setor "
											+ e.getMessage()));
		}
	}

	public void alterar() {
		try {
			SetorRN setRN = new SetorRN();
			Integer retorno = setRN.validaCampoNulo(this.setor, this.listaGrupoExib);
			if (retorno == 0) {
				this.setor.setGrupo(this.listaGrupoExib);
				setRN.altSet(this.setor);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Setor alterado com sucesso"));
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
									"Info", "Problemas na alteração do Setor "
											+ e.getMessage()));
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
		this.setor = new Setor();
		this.listaSetor = new ArrayList<Setor>();
		this.listaGrupoExib = new ArrayList<Grupo>();
	}

	public void remover() {
		try {
			SetorRN setRN = new SetorRN();
			Integer retorno = setRN.verificaRemocao(this.setor);
			if (retorno == 0) {
				setRN.remover(this.setor);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Setor removido com sucesso"));
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
										"Remoção não permitida! Existem Produtos vinculados a este Setor. "));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção do Setor " + e.getMessage()));
		}
	}

	public void buscarSetor() {
		limpar();
		SetorRN setRN = new SetorRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaSetor = setRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.listaSetor = setRN.consultaDesc(busca);
			}else if (filtro.equals("idGrup")) {
				this.listaSetor = setRN.consultaIdGrup(Long.parseLong(busca));
			}else if (filtro.equals("descGrup")) {
				this.listaSetor = setRN.consultaDescGrup(busca);
			}
		} else {
			this.listaSetor = setRN.listar();
		}
	}

	public void remGru() {
		SetorRN setRN = new SetorRN();
		Integer retorno = setRN.verificaRemocaoRelGrupo(this.setor, idGrup);
		if (retorno == 0) {
			List<Grupo> listaGruNovo = new ArrayList<Grupo>();
			listaGruNovo.addAll(this.listaGrupoExib);
			for (Grupo gru : this.listaGrupoExib) {
				if (gru.getIdGrupo().equals(this.idGrup)) {
					listaGruNovo.remove(gru);
				}
			}
			this.listaGrupoExib = new ArrayList<Grupo>();
			this.listaGrupoExib.addAll(listaGruNovo);
		} else {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info",
									"Remoção não permitida! Existem Produtos vinculados a este Setor e Grupo. "));
		}
	}

	public void editSet() {
		SetorRN setRN = new SetorRN();
		this.listaGrupoExib = new ArrayList<Grupo>();
		this.setor = setRN.editSet(this.id);
		this.listaGrupoExib.addAll(this.setor.getGrupo());
		habilita();
		this.alt = false;
		this.vig = false;
		this.rem = false;
		this.sal = true;
	}

	public void incluirGrup() {
		if (this.grupo != null) {
			Integer retorno = verificaInclusaoGrupo();
			if (retorno == 0) {
				this.listaGrupoExib.add(this.grupo);
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Grupo já vinculado no Setor!"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Escolha uma Grupo para incluir."));
		}
	}

	public void habilita() {
		this.desc = false;
	}

	public void desabilita() {
		this.desc = true;
	}

	private Integer verificaInclusaoGrupo() {
		Integer retorno = 0;
		for (Grupo gru : this.listaGrupoExib) {
			if (gru.getIdGrupo().equals(this.grupo.getIdGrupo()))
				retorno++;
		}
		return retorno;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Setor> getListaSetor() {
		return listaSetor;
	}

	public void setListaSetor(List<Setor> listaSetor) {
		this.listaSetor = listaSetor;
	}

	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}

	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
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

	public List<Grupo> getListaGrupoExib() {
		return listaGrupoExib;
	}

	public void setListaGrupoExib(List<Grupo> listaGrupoExib) {
		this.listaGrupoExib = listaGrupoExib;
	}

	public Long getIdGrup() {
		return idGrup;
	}

	public void setIdGrup(Long idGrup) {
		this.idGrup = idGrup;
	}

}
