package br.com.softwareOptimus.entidades.bens.geral;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.RN.geral.EstadoRN;
import br.com.softwareOptimus.entidades.RN.geral.MunicipioRN;

@ManagedBean
public class GeralBean {
	
	private List<Estado> estados;
	private List<Municipio> municipios;
	private EstadoRN estadoRN = new EstadoRN();
	private MunicipioRN municipioRN = new MunicipioRN();
	private Estado uf = new Estado();
	private Municipio municipio = new Municipio();
	
	public GeralBean(){
		setEstados(this.estadoRN.listaEstado());
	}
	
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}


	public Estado getUf() {
		return uf;
	}


	public void setUf(Estado uf) {
		this.uf = uf;
	}
	
	public List<Municipio> getMunicipios() {
		return municipios;
	}
	
	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
	public void filtraEstado(){
		this.municipios = municipioRN.listaMunicipios(uf);
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}
