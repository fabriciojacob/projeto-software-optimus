package br.com.softwareOptimus.fiscal.RN;

import java.util.List;

import br.com.softwareOptimus.dao.fiscal.CodTabelaGovDAO;
import br.com.softwareOptimus.dao.fiscal.TipoProdutoDAO;
import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.Ncm;
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
		if (prod.size() != 0) {
			return 1;
		} else {
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
		if (tbGov.getAliquotaIpi() == null || tbGov.getEntradaCofins() == null
				|| tbGov.getEntradaPis() == null || tbGov.getNcm() == null
				|| tbGov.getSaidaCofins() == null
				|| tbGov.getSaidaPis() == null
				|| tbGov.getTipoItem().equals("")
				|| tbGov.getVigencia() == null) {
			retorno = 1;
		}
		return retorno;
	}

	public void salvaVig(CodTabelaGov tbGov) {
		this.codTbDAO.salvar(tbGov);
	}

	public List<Ncm> consultaNCMCod(String busca) {
		return this.tipoProdutoDAO.consultaNCMCod(busca);
	}

	public List<Ncm> consultaNCMDesc(String busca) {
		return this.tipoProdutoDAO.consultaNCMDesc(busca);
	}

	public List<Ncm> consultaNatDesc(String busca) {
		return this.tipoProdutoDAO.consultaNatDesc(busca);
	}

	public List<Ncm> consultaNatCod(String busca) {
		return this.tipoProdutoDAO.consultaNatCod(busca);
	}

	public List<Ncm> consultaTbDesc(String busca) {
		return this.tipoProdutoDAO.consultaTbDesc(busca);
	}

	public Ncm consultaNCMId(Long idNcm) {
		return this.tipoProdutoDAO.consultaNCMId(idNcm);
	}

	public CodTabelaGov editVig(Long idVig) {	
		return this.codTbDAO.editVig(idVig);
	}

	public void salvaVig2(CodTabelaGov tbGov) {
		this.codTbDAO.salvaVig2(tbGov);
	}

	public List<TipoProduto> listarTipoVig() {
		return this.tipoProdutoDAO.listarTipoVig();
	}
}
