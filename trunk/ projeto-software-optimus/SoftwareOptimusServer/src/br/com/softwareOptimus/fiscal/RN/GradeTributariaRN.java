package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.GradeTributariaDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class GradeTributariaRN {
	
	private GradeTributariaDAO gradeTribDAO;
	
	public GradeTributariaRN(){
		this.gradeTribDAO = DAOFactory.criaGradeTribDAO();
	}

}
