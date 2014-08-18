package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.GradeTributariaDAO;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.util.DAOFactory;

public class GradeTributariaRN {

	private GradeTributariaDAO gradeTribDAO;

	public GradeTributariaRN() {
		this.gradeTribDAO = DAOFactory.criaGradeTribDAO();
	}

	/*public Integer validaCampoNulo(GradeTributaria grade) {
		Integer retorno = 0;
		if (grade.getAliquota() == null || grade.getDescricao().equals("")
				|| grade.getDestino().equals("")
				|| grade.getOrigem().equals("") || grade.getIo().equals("")
				|| grade.getTipoGrade().equals("")) {
			retorno = 1;
		}
		return retorno;
	}

	public void altGrade(GradeTributaria grade) {
		this.gradeTribDAO.altGrade(grade);
	}

	public void salva(GradeTributaria grade) {
		this.gradeTribDAO.salva(grade);
	}

	public void remover(GradeTributaria grade) {
		this.gradeTribDAO.remover(grade);
	}*/

}
