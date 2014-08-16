package br.com.softwareOptimus.fiscal.RN;

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
		if (figura.getDescricao().equals("")){
			retorno = 1;
		}
		return retorno;
	}

	public void salvar(FiguraFiscal figura) {
		this.figuraDAO.salva(figura);
	}

}
