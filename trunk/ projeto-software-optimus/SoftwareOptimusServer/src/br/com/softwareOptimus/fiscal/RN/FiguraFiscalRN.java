package br.com.softwareOptimus.fiscal.RN;

import java.util.List;
import br.com.softwareOptimus.dao.fiscal.FiguraFiscalDAO;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.util.DAOFactory;

public class FiguraFiscalRN {
	
	private FiguraFiscalDAO figuraDAO;
	
	public FiguraFiscalRN(){
		this.figuraDAO = DAOFactory.criaFiguraDAO();
	}

	public Integer validaCampoNulo(FiguraFiscal figura) {
		Integer retorno = 0;
		if (figura.getDescricao().equals("") || figura.getGrades().isEmpty()){
			retorno = 1;
		}
		return retorno;
	}

	public void salvar(FiguraFiscal figura) {
		this.figuraDAO.salva(figura);
	}

	public void altFigura(FiguraFiscal figura) {
		this.figuraDAO.altFigura(figura);
	}

	public void remover(FiguraFiscal figura) {
		this.figuraDAO.remover(figura);
	}

	public List<FiguraFiscal> consultaId(long id) {
		return this.figuraDAO.consultaId(id);
	}

	public List<FiguraFiscal> consultaDesc(String desc) {
		return this.figuraDAO.consultaDesc(desc);
	}

	public List<FiguraFiscal> listar() {
		return this.figuraDAO.listar();
	}

	public FiguraFiscal editFigura(Long id) {
		return this.figuraDAO.editFigura(id);
	}
}
