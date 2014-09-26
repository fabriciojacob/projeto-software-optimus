package br.com.softwareOptimus.produto.RN;

import br.com.softwareOptimus.dao.produto.SetorDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class SetorRN {
	
	private SetorDAO setorDAO;
	
	public SetorRN(){
		this.setorDAO = DAOFactory.criaSetorDAO();
	}

}
