package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.PautaDAO;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.util.DAOFactory;

public class PautaRN {

	private PautaDAO pautaDAO;

	public PautaRN() {
		this.pautaDAO = DAOFactory.criaPautaDAO();
	}

	public Integer validaCampoNulo(Pauta pauta) {
		Integer retorno = 0;
		if (pauta.getDescricao().equals("")) {
			retorno = 1;
		}
		return retorno;
	}

	public void salvar(Pauta pauta) {
		this.pautaDAO.salvar(pauta);		
	}
}
