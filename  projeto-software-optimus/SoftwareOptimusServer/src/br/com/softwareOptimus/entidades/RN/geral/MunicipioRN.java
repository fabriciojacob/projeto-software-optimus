package br.com.softwareOptimus.entidades.RN.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.dao.geral.MunicipioDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class MunicipioRN {
	
	private MunicipioDAO municipioDAO;
	
	public MunicipioRN(){
		this.municipioDAO = DAOFactory.criaMunicipioDAO();
	}
	
	public List<Municipio> listaMunicipios(Estado uf){
		return this.municipioDAO.lista(uf);
	}

}
