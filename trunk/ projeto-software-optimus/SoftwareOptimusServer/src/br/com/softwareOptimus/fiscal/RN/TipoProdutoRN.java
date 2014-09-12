package br.com.softwareOptimus.fiscal.RN;

import java.util.List;

import br.com.softwareOptimus.dao.fiscal.CodTabelaGovDAO;
import br.com.softwareOptimus.dao.fiscal.TipoProdutoDAO;
import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.util.DAOFactory;

public class TipoProdutoRN {

	private TipoProdutoDAO tipoProdutoDAO;
	private CodTabelaGovDAO codTbDAO;

	public TipoProdutoRN() {
		this.tipoProdutoDAO = DAOFactory.criaTipoProdutoDAO();
		this.codTbDAO = DAOFactory.criaCodTabelaGovDAO();
	}

	public Integer validaCampoNulo(TipoProduto tipo) {
		Integer retorno = 0;
		if (tipo.getDescricao().equals("")) {
			retorno = 1;
		}
		return retorno;
	}

	public void salvar(TipoProduto tipo) {
		this.tipoProdutoDAO.salva(tipo);
	}

	public void altTipo(TipoProduto tipo) {
		this.tipoProdutoDAO.altTipo(tipo);
	}

	public Integer verificaRemocao(TipoProduto tipo) {
		List<Produto> prod = this.tipoProdutoDAO.verificaRemocao(tipo);
		if(prod.size() != 0){
			return 1;
		}else{
			return 0;
		}
	}

	public void remover(TipoProduto tipo) {
		this.tipoProdutoDAO.remover(tipo);
	}

	public List<TipoProduto> consultaId(long id) {
		return this.tipoProdutoDAO.consultaId(id);
	}

	public List<TipoProduto> listar() {
		return this.tipoProdutoDAO.lista();
	}

	public List<TipoProduto> consultaDesc(String busca) {
		return this.tipoProdutoDAO.consultaDesc(busca);
	}

	public TipoProduto editTipo(Long id) {
		return this.tipoProdutoDAO.editaTipo(id);
	}

	public List<CodTabelaGov> listarVig(TipoProduto tipo) {
		return this.codTbDAO.listaVig(tipo);
	}

	public void removerVig(Long idVig) {
		this.codTbDAO.remover(idVig);
	}

	public Integer validaCampoNuloVig(CodTabelaGov tbGov) {
		Integer retorno = 0;
		if (tbGov.getAliquotaIpi().equals("")
				|| tbGov.getEntradaCofins().equals("")
				|| tbGov.getEntradaPis().equals("")
				|| tbGov.getNcm().equals("")
				|| tbGov.getSaidaCofins().equals("")
				|| tbGov.getSaidaPis().equals("")
				|| tbGov.getTipoItem().equals("")
				|| tbGov.getVigencia().equals("")) {			
			retorno = 1;
		}
		return retorno;
	}

	public void salvaVig(CodTabelaGov tbGov) {
		this.codTbDAO.salvar(tbGov);
	}
}
