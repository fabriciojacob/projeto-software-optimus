package br.com.softwareOptimus.com.comercial.RN;

import java.util.List;

import br.com.softwareOptimus.com.comercial.dao.CotacaoDAO;
import br.com.softwareOptimus.comercial.Cotacao;
import br.com.softwareOptimus.util.DAOFactory;

public class CotacaoRN {

	private CotacaoDAO cotacaoDAO;

	public CotacaoRN() {
		cotacaoDAO = DAOFactory.criaCotacao();
	}

	public List<Cotacao> lista() throws Exception {
		return cotacaoDAO.lista();
	}

	public Cotacao find(Long id) throws Exception {
		return cotacaoDAO.cotacao(id);
	}

	public void salvar(Cotacao cotacao) throws Exception {
		cotacaoDAO.salvar(cotacao);
	}

}
