package br.com.softwareOptimus.comercial.RN;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.comercial.Requisicao;
import br.com.softwareOptimus.comercial.TipoOrigem;
import br.com.softwareOptimus.comercial.dao.RequisicaoDAO;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.util.DAOFactory;

public class RequisicaoRN {

	private RequisicaoDAO requisicaoDAO;

	public RequisicaoRN() {
		requisicaoDAO = DAOFactory.criaRequisicao();
	}

	public List<Requisicao> listaReq() throws Exception {
		return requisicaoDAO.lista();
	}

	public Requisicao find(Long id) throws Exception {
		return requisicaoDAO.requisicao(id);
	}

	public RequisicaoDAO getRequisicaoDAO() {
		return requisicaoDAO;
	}

	public void setRequisicaoDAO(RequisicaoDAO requisicaoDAO) {
		this.requisicaoDAO = requisicaoDAO;
	}

	public String salvar(Requisicao requisicao, Usuario user, Pessoa empresa,
			String tipoRequisicao) throws Exception {
		
		if ((user != null)	&& (tipoRequisicao != null) && (empresa != null)) {
			if (tipoRequisicao.equals("PED")) {
				requisicao.setTipoOrigem(TipoOrigem.PEDIDO_VENDA);
			} else if (tipoRequisicao.equals("RM")) {
				requisicao.setTipoOrigem(TipoOrigem.REQUISICAO_MATERIAL);
			} else if (tipoRequisicao.equals("OR")) {
				requisicao.setTipoOrigem(TipoOrigem.ORDEM_FABRICACAO);
			} else {
				requisicao.setTipoOrigem(null);
			}
			requisicao.setEmpresa(empresa);
			requisicao.setUsuRequisita(user);
			this.requisicaoDAO.salvar(requisicao);
			return "Requisição salva com sucesso !!! ";
		} else if ((user == null) && (tipoRequisicao == null)) {
			return "Usuário e tipo de requisição não foram preenchidos !!! ";
		} else if ((user == null) && (empresa == null)){
			return "Usuario e empresa não foram preenchidos !!! ";
		}else if((empresa == null) && (tipoRequisicao == null)){
			return "Empresa e tipo de requisição não foram preenchidos !!! ";
		}else if(user == null){
			return "Usuário não foi vinculado na requisição !!! ";
		}else if(empresa == null){
			return "Empresa não foi selecionada !!! ";
		}else{
			return "Tipo de requisição não foi selecionada !!! ";
		}
	}

	public void setTipoReq(String tipoRequisicao) {

	}

	public void editar(Requisicao requisicao) throws Exception {
		this.requisicaoDAO.editar(requisicao);
	}

	public void excluir(Requisicao requisicao) throws Exception {
		this.requisicaoDAO.excluir(requisicao);
	}

	public List<Requisicao> listaRequisicao(String descricao) throws Exception {
		return this.requisicaoDAO.pesquisaDescricao(descricao);
	}

	public List<Requisicao> listaReqDate(Date dataIni, Date dataFim)
			throws Exception {
		return this.requisicaoDAO.pesquisaPeriodo(dataIni, dataFim);
	}

}
