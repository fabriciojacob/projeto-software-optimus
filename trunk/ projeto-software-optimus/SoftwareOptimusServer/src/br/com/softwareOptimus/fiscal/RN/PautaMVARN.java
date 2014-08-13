package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.PautaMVADAO;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.util.DAOFactory;

public class PautaMVARN {

	private PautaMVADAO pautaMVADAO;

	public PautaMVARN() {
		this.pautaMVADAO = DAOFactory.criaPautaMVADAO();
	}

	public void salva(PautaMVA pauta) {
		this.pautaMVADAO.salva(pauta);
	}

	public Integer validaCampoNulo(PautaMVA pauta) {
		Integer retorno = 0;
		if (pauta.getDescricao().equals("") || pauta.getValorMVa() == null
				|| pauta.getVigencia() == null || pauta.getValorPauta() == null || pauta.getVigencia() == null) {
			retorno = 1;
		}
		return retorno;
	}

	public void altPauta(PautaMVA pauta) {
		this.pautaMVADAO.alterar(pauta);
	}

	public void remover(PautaMVA pauta) {
		this.pautaMVADAO.remover(pauta);
	}
}
