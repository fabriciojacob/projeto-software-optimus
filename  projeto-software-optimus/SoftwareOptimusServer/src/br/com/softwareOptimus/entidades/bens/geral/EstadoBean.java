package br.com.softwareOptimus.entidades.bens.geral;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.RN.geral.EstadoRN;

@ManagedBean
@ViewScoped
public class EstadoBean {
	
	private List<Estado> estados = new ArrayList<>();
	private EstadoRN estadoRN = new EstadoRN();
	
	public EstadoBean(){
		setEstados(this.estadoRN.listaEstado());
	}
	
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	

}
