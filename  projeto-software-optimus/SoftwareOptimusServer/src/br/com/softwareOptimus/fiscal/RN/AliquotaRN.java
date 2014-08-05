package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.AliquotaDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class AliquotaRN {
	
	private AliquotaDAO aliquotaDAO;
	
	public AliquotaRN(){
		this.aliquotaDAO = DAOFactory.criaAliquotaDAO();
	}
}