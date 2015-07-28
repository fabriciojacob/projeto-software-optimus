package br.com.softwareOptimus.financeiro.RN;

import java.util.List;

import br.com.softwareOptimus.financeiro.CondPgto;
import br.com.softwareOptimus.financeiro.dao.CondPgtoDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class CondPgtoRN {
	
	private CondPgtoDAO condDAO;
	
	public CondPgtoRN(){
		this.condDAO = DAOFactory.criaCondPgto();
	}
	
	public void salvar(CondPgto condPgto) throws Exception{
		this.condDAO.salvar(condPgto);
	}
	
	public void remover(CondPgto condPgto) throws Exception{
		this.condDAO.excluir(condPgto);
	}
	
	public void editar(CondPgto condPgto) throws Exception {
		this.condDAO.editar(condPgto);
	}
	
	public List<CondPgto> listar() throws Exception {
		return this.condDAO.listar();
	}
	
	public CondPgto selecionar(Long id) throws Exception{
		return this.condDAO.find(id);
	}

}
