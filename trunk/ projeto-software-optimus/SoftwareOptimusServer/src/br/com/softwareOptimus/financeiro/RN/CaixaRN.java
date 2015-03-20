package br.com.softwareOptimus.financeiro.RN;

import java.util.List;
import br.com.softwareOptimus.com.financeiro.dao.CaixaDAO;
import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.util.DAOFactory;

public class CaixaRN {

	private CaixaDAO caixaDAO;

	public CaixaRN() {
		this.caixaDAO = DAOFactory.criaCaixa();
	}

	public List<Caixa> listaCaixa() throws Exception {
		return this.caixaDAO.listaCaixa();
	}

	public void salvar(Caixa caixa) throws Exception {
		this.caixaDAO.salvar(caixa);
	}

	public void editar(Caixa caixa) throws Exception {
		this.caixaDAO.editar(caixa);
	}

	public void excluir(Caixa caixa) throws Exception {
		this.caixaDAO.excluir(caixa);
	}

	public Caixa pesquisaID(Long id) throws Exception {
		return this.caixaDAO.pesquisaID(id);
	}

	public List<Caixa> pesquisaCaixa(String descricao) throws Exception {
		return this.caixaDAO.pesquisaCaixa(descricao);
	}

}
