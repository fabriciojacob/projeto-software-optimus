package br.com.softwareOptimus.produto.RN;

import br.com.softwareOptimus.dao.produto.GrupoDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class GrupoRN {
	
	private GrupoDAO grupoDAO;

	public GrupoRN(){
		this.grupoDAO = DAOFactory.criaGrupoDAO();
	}
}
