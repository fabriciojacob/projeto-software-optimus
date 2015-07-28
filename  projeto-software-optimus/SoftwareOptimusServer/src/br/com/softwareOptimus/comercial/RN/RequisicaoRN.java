package br.com.softwareOptimus.comercial.RN;

import java.util.List;

import br.com.softwareOptimus.comercial.Requisicao;
import br.com.softwareOptimus.comercial.dao.RequisicaoDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class RequisicaoRN {
	
	private RequisicaoDAO requisicaoDAO;
	
	public RequisicaoRN(){
		requisicaoDAO = DAOFactory.criaRequisicao();
	}
	
	public List<Requisicao> listaReq() throws Exception{
		return requisicaoDAO.lista();
	}
	
	public Requisicao find(Long id) throws Exception{
		return requisicaoDAO.requisicao(id);
	}

	public RequisicaoDAO getRequisicaoDAO() {
		return requisicaoDAO;
	}

	public void setRequisicaoDAO(RequisicaoDAO requisicaoDAO) {
		this.requisicaoDAO = requisicaoDAO;
	}
	
	public void salvar(Requisicao requisicao) throws Exception{
		this.requisicaoDAO.salvar(requisicao);
	}

}
