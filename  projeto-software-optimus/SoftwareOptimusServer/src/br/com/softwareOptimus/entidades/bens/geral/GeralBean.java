package br.com.softwareOptimus.entidades.bens.geral;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.RN.geral.EstadoRN;
import br.com.softwareOptimus.entidades.RN.geral.MunicipioRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "geralBean")
@SessionScoped
public class GeralBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = -2566411116709206423L;
	private List<Estado> estados;
	private List<Municipio> municipios;
	private EstadoRN estadoRN;
	private MunicipioRN municipioRN;
	private Estado uf;
	private Municipio municipio;

	public GeralBean() {
		this.setEstados(this.getEstadoRN().listaEstado());
	}

	public List<Estado> getEstados() {
		if(this.estados == null){
			this.estados = new ArrayList<Estado>();
		}
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getUf() {
		if(this.uf == null){
			this.uf = new Estado();
		}
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	public List<Municipio> getMunicipios() {
		if(this.municipios == null){
			this.municipios = new ArrayList<Municipio>();
		}
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public void filtraEstado() {
		this.setMunicipios(this.getMunicipioRN().listaMunicipios(this.getUf()));
	}

	public Municipio getMunicipio() {
		if(this.municipio == null){
			this.municipio = new Municipio();
		}
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public EstadoRN getEstadoRN() {
		if(this.estadoRN == null){
			this.estadoRN = new EstadoRN();
		}
		return estadoRN;
	}

	public void setEstadoRN(EstadoRN estadoRN) {
		this.estadoRN = estadoRN;
	}

	public MunicipioRN getMunicipioRN() {
		if(this.municipioRN == null){
			this.municipioRN = new MunicipioRN();		
		}
		return municipioRN;
	}

	public void setMunicipioRN(MunicipioRN municipioRN) {
		this.municipioRN = municipioRN;
	}
}
