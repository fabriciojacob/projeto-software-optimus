package br.com.softwareOptimus.financeiro.RN;

import java.util.List;

import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.dao.ContaBancariaDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class ContaBancariaRN {

	private ContaBancariaDAO contaDAO;

	public ContaBancariaRN() {
		this.contaDAO = DAOFactory.criaContaBancDAO();
	}

	public void salvar(ContaBancaria conta) throws Exception {
		this.contaDAO.salvarConta(conta);
	}

	public List<ContaBancaria> listaGeral() throws Exception {
		return this.contaDAO.listaGeral();
	}

	public void alterar(ContaBancaria conta) throws Exception {
		this.contaDAO.alterar(conta);
	}

	public void excluirConta(ContaBancaria conta) throws Exception {
		this.contaDAO.excluirConta(conta);
	}

	public List<ContaBancaria> pesquisaTitular(String titular) throws Exception {
		return this.contaDAO.pesquisaTitular(titular);
	}

	public ContaBancaria pesquisaID(Long id) throws Exception {
		return this.contaDAO.pesquisaID(id);
	}

}