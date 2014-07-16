package br.com.softwareOptimus.entidades.RN.geral;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class LogradouroRN {
	
	private LogradouroDAO logradouroDAO;
	
	public LogradouroRN(){
		this.logradouroDAO = DAOFactory.criaLogrDAO();
	}
	
	public Logradouro carregar(Long codigo){
		return this.logradouroDAO.carregar(codigo);
	}
	
	public void salvar(Logradouro logr){
		Long codigo = logr.getIdEndereco();
		if(codigo == null || codigo == 0){
			this.logradouroDAO.salvar(logr);
		}else{
			this.logradouroDAO.atualizar(logr);
		}
	}
	

}
