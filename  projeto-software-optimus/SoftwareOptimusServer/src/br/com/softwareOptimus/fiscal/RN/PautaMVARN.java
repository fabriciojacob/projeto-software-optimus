package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.PautaMVADAO;
import br.com.softwareOptimus.util.DAOFactory;

public class PautaMVARN {
	
	private PautaMVADAO pautaMVADAO;

	public PautaMVARN(){
		this.pautaMVADAO = DAOFactory.criaPautaMVADAO();
	}

}
