package br.com.softwareOptimus.financeiro.RN;

import java.util.List;

import br.com.softwareOptimus.financeiro.FormaPgto;
import br.com.softwareOptimus.financeiro.dao.FormaPgtoDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class FormaPgtoRN {
	
	private FormaPgtoDAO formaDAO;
	
	public FormaPgtoRN(){
		this.formaDAO = DAOFactory.formaPgtoDAO();
	}
	
	public void salvar(FormaPgto formaPgto) throws Exception{
		this.formaDAO.salvar(formaPgto);
	}
	
	public void editar(FormaPgto formaPgto) throws  Exception{
		this.formaDAO.editar(formaPgto);
	}
	
	public void remover(FormaPgto formaPgto) throws Exception{
		this.formaDAO.excluir(formaPgto);
	}
	
	public List<FormaPgto> listar(String descricao) throws Exception {
		return this.formaDAO.lista(descricao);
	}

	public FormaPgtoDAO getFormaDAO() {
		return formaDAO;
	}

	public void setFormaDAO(FormaPgtoDAO formaDAO) {
		this.formaDAO = formaDAO;
	}
	
	public FormaPgto selecionar(Long id) throws Exception {
		return this.formaDAO.selecionar(id);
	}
	
	

}
