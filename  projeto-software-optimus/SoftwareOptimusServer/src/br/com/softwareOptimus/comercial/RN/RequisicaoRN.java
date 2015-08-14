package br.com.softwareOptimus.comercial.RN;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.comercial.Requisicao;
import br.com.softwareOptimus.comercial.RequisicaoItens;
import br.com.softwareOptimus.comercial.StatusGeral;
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
			String tipoRequisicao, int tipoOper) throws Exception {

		if ((user != null) && (tipoRequisicao != null) && (empresa != null)) {
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
			if (requisicao.getDataReq() == null) {
				Date data = new Date(System.currentTimeMillis());
				requisicao.setDataReq(data);
			}
			if (tipoOper == 1) {
				requisicao.setStatusGeral(StatusGeral.PENDENTE);
				this.requisicaoDAO.salvar(requisicao);
			} else {
				editar(requisicao);
				return "Registor editado com sucesso !!!";
			}
			return "Requisição salva com sucesso !!! ";
		} else if ((user == null) && (tipoRequisicao == null)) {
			return "Usuário e tipo de requisição não foram preenchidos !!! ";
		} else if ((user == null) && (empresa == null)) {
			return "Usuario e empresa não foram preenchidos !!! ";
		} else if ((empresa == null) && (tipoRequisicao == null)) {
			return "Empresa e tipo de requisição não foram preenchidos !!! ";
		} else if (user == null) {
			return "Usuário não foi vinculado na requisição !!! ";
		} else if (empresa == null) {
			return "Empresa não foi selecionada !!! ";
		} else {
			return "Tipo de requisição não foi selecionada !!! ";
		}
	}

	public void editar(Requisicao requisicao) throws Exception {
		this.requisicaoDAO.editar(requisicao);
	}

	public int excluir(Requisicao requisicao) throws Exception {
		// 0 ok, 1  requisição ja enviada
		// somente enviar se houver produtos
		if(requisicao.getStatusGeral().toString().equals("ENVIADA")){
			return 1;
		}else{
			this.requisicaoDAO.excluir(requisicao);
			return 0;
		}
	}
	
	public int countRequisicao() throws Exception{
		return this.requisicaoDAO.countRequisicaoPaginacao();
	}
	
	public Long enviarRequisicao(Requisicao requisicao) throws Exception{
		return this.requisicaoDAO.countProdutos(requisicao);
	}

	public List<Requisicao> listaRequisicao(String descricao) throws Exception {
		return this.requisicaoDAO.pesquisaDescricao(descricao);
	}

	public List<Requisicao> listaReqDate(Date dataIni, Date dataFim, String desc, int first, int pageSize)
			throws Exception {
		return this.requisicaoDAO.pesquisaPeriodo(dataIni, dataFim, desc, first, pageSize);
	}
	
	public void salvarRequisicaoItem(RequisicaoItens reqItem) throws Exception{
		this.requisicaoDAO.salvarRequisicaoItem(reqItem);
	}
	
	public void editarRequisicaoItem(RequisicaoItens reqItem) throws Exception {
		this.requisicaoDAO.atualizarRequisicaoItem(reqItem);
	}

}
