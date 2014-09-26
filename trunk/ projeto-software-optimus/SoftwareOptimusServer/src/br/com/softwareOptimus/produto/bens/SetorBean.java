package br.com.softwareOptimus.produto.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Setor;

@ManagedBean(name = "setorBean")
@ViewScoped
public class SetorBean{

	private Setor setor = new Setor();
	private Grupo grupo = new Grupo();
	private List<Setor> listaSetor = new ArrayList<Setor>();
	private List<Grupo> listaGrupo = new ArrayList<Grupo>();
	private String busca, filtro;
	private boolean sal = true, alt = true, rem = true, desc = true,
			vig = true;
	private Long id, idSub;
	
	public SetorBean(){
		
	}
	
	public void novo(){
		
	}
	
	public void salvar(){
		
	}
	
	public void alterar(){
		
	}
	
	public void cancelar(){
		
	}
	
	public void limpar(){
		
	}
	
	public void remover(){
		
	}
	
	public void buscarSetor(){
		
	}
	
	public void remGru(){
		
	}
	
	public void editSet(){
		
	}
	
	public void incluirGrup(){
		
	}
	
	public void habilita(){
		
	}
	
	public void desabilita(){
		
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

	public Long getIdSub() {
		return idSub;
	}

	public void setIdSub(Long idSub) {
		this.idSub = idSub;
	}
	
	
}
