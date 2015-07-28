package br.com.softwareOptimus.financeiro.RN;

import java.util.List;

import br.com.softwareOptimus.financeiro.Conta;
import br.com.softwareOptimus.financeiro.ContaFilha;
import br.com.softwareOptimus.financeiro.dao.ContaDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class ContaRN {

	private ContaDAO contaDAO;

	public ContaRN() {
		this.contaDAO = DAOFactory.criaContaDAO();
	}

	public void salvarConta(Conta conta) throws Exception {
		contaDAO.salvar(conta);
	}

	public void alterar(Conta conta) throws Exception {
		contaDAO.alterarConta(conta);
	}

	public Conta pesquisaConta(Long id) throws Exception {
		return contaDAO.pesquisaConta(id);
	}

	public List<ContaFilha> listaContaFilha(Conta conta) throws Exception {
		return contaDAO.listaContaFilha(conta);
	}

	public List<Conta> pesquisaConta(String descricao) throws Exception {
		return contaDAO.pesquisaConta(descricao);
	}

	public void excluirContaFilha(ContaFilha conta) throws Exception {
		contaDAO.excluirContaFilha(conta);
	}
	
	public ContaFilha localizaContaFilha(Long id) throws Exception {
		return contaDAO.localizaContaFilha(id);
	}
	
	public void salvarContaFilha(ContaFilha conta) throws Exception {
		contaDAO.salvarContaFilha(conta);
	}
	

}
