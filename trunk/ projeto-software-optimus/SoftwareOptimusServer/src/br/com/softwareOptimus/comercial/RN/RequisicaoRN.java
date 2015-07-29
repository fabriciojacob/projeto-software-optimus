package br.com.softwareOptimus.comercial.RN;

import java.util.Date;
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
	
	public void editar(Requisicao requisicao) throws Exception{
		this.requisicaoDAO.editar(requisicao);
	}
	
	public void excluir(Requisicao requisicao) throws Exception{
		this.requisicaoDAO.excluir(requisicao);
	}
	
	public List<Requisicao> listaRequisicao(String descricao) throws Exception{
		return this.requisicaoDAO.pesquisaDescricao(descricao);
	}
	
	public List<Requisicao> listaReqDate(Date dataIni, Date dataFim) throws Exception {
		return this.requisicaoDAO.pesquisaPeriodo(dataIni, dataFim);
	}

}
