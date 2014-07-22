package br.com.softwareOptimus.entidades.RN;

import br.com.softwareOptimus.dao.produto.UnidMedDAO;
import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.util.DAOFactory;

public class UnidMedRN {

	private UnidMedDAO unidMedDAO;

	public UnidMedRN() {
		this.unidMedDAO = DAOFactory.criaUnidMedDAO();
	}

	public void salvar(UnidMed unidMed) {
		this.unidMedDAO.salvar(unidMed);
	}
}
