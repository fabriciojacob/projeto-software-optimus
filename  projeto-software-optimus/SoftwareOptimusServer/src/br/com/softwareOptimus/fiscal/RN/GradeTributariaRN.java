package br.com.softwareOptimus.fiscal.RN;

import java.util.List;

import br.com.softwareOptimus.dao.fiscal.GradeTributariaDAO;
import br.com.softwareOptimus.dao.fiscal.GradeTributariaVigenciaDAO;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.util.DAOFactory;

public class GradeTributariaRN {

	private GradeTributariaDAO gradeTribDAO;
	private GradeTributariaVigenciaDAO gradeTribVigDAO;

	public GradeTributariaRN() {
		this.gradeTribDAO = DAOFactory.criaGradeTribDAO();
		this.gradeTribVigDAO = DAOFactory.criaGradeTribVigDAO();
	}

	public Integer validaCampoNulo(GradeTributaria grade) {
		Integer retorno = 0;
		if (grade.getDescricao().equals("")) {
			retorno = 1;
		}
		return retorno;
	}

	public void salvar(GradeTributaria grade) {
		this.gradeTribDAO.salvar(grade);
	}

	public void altGrade(GradeTributaria grade) {
		this.gradeTribDAO.altGrade(grade);
	}

	public void remover(GradeTributaria grade) {
		this.gradeTribDAO.remover(grade);
	}

	public List<GradeTributariaVigencia> listarVig(GradeTributaria grade) {
		return this.gradeTribVigDAO.listaVig(grade);
	}
}
