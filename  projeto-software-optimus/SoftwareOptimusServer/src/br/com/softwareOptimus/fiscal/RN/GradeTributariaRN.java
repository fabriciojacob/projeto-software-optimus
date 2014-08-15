package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.GradeTributariaDAO;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.util.DAOFactory;

public class GradeTributariaRN {
	
	private GradeTributariaDAO gradeTribDAO;
	
	public GradeTributariaRN(){
		this.gradeTribDAO = DAOFactory.criaGradeTribDAO();
	}

	public Integer validaCampoNulo(GradeTributaria grade) {
		return null;
	}

	public void altGrade(GradeTributaria grade) {
		this.gradeTribDAO.altGrade(grade);
	}

	public void salva(GradeTributaria grade) {
		this.gradeTribDAO.salva(grade);
	}

	public void remover(GradeTributaria grade) {
		this.gradeTribDAO.remover(grade);
	}

}
