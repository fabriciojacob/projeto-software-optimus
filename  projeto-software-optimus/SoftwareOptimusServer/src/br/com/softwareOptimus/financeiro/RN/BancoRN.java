package br.com.softwareOptimus.financeiro.RN;

import java.util.List;

import br.com.softwareOptimus.com.financeiro.dao.BancoDAO;
import br.com.softwareOptimus.financeiro.Banco;
import br.com.softwareOptimus.util.DAOFactory;

public class BancoRN {

	private BancoDAO bancoDAO;

	public BancoRN() {
		this.bancoDAO = DAOFactory.criaBanco();
	}

	public Banco pesquisaBanco(String id) throws Exception {
		return this.bancoDAO.banco(id);
	}

	public List<Banco> pesquisa() throws Exception {
		return this.bancoDAO.pesquisa();
	}

	public BancoDAO getBancoDAO() {
		return bancoDAO;
	}

	public void setBancoDAO(BancoDAO bancoDAO) {
		this.bancoDAO = bancoDAO;
	}

}
