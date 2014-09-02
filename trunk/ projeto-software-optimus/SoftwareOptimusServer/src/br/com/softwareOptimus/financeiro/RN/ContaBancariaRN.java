package br.com.softwareOptimus.financeiro.RN;

import java.util.List;

import br.com.softwareOptimus.com.financeiro.dao.ContaBancariaDAO;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.util.DAOFactory;

public class ContaBancariaRN {

	private ContaBancariaDAO contaDAO;

	public ContaBancariaRN() {
		this.contaDAO = DAOFactory.criaContaBancDAO();
	}

	public void salvar(ContaBancaria conta) throws Exception {
		this.contaDAO.salvarConta(conta);
	}
	
	public void alterar(ContaBancaria conta) throws Exception {
		this.contaDAO.alterar(conta);
	}

	public void excluirConta(ContaBancaria conta) throws Exception {
		this.contaDAO.excluirConta(conta);
	}
	
	public List<ContaBancaria> pesquisaConta(Integer conta) throws Exception{
		return this.contaDAO.pesquisaConta(conta);
	}
	
	public List<ContaBancaria> pesquisaAgencia(Integer agencia) throws Exception{
		return this.contaDAO.pesquisaAgencia(agencia);
	}
	
	public List<ContaBancaria> pesquisaTodos(Integer agencia, String titular, Integer conta) throws Exception{
		return this.contaDAO.pesquisaTodos(titular, conta, agencia);
	}

}