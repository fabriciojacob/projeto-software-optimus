package br.com.softwareOptimus.produto.bens;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.SubGrupo;

@ManagedBean(name= "subGrupoBean")
@ViewScoped
public class SubGrupoBean {

	private SubGrupo subGrupo = new SubGrupo();
	private Categoria categoria = new Categoria();
	private boolean sal = true, alt = true, rem = true, desc = true;
	
	public SubGrupoBean(){
		
	}
	
	public void novo(){
		
	}
	
	public void alterar(){
		
	}
	
	public void cancelar(){
		
	}
	
	public void limpar(){
		
	}
	
	public void salvar(){
		
	}
	
	public void remover(){
		
	}
	
	public void habilita(){
		
	}
	
	public void desabilita(){
		
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public SubGrupo getSubGrupo() {
		return subGrupo;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}
	
	public boolean isDesc() {
		return desc;
	}
	
	public void setDesc(boolean desc) {
		this.desc = desc;
	}
}

