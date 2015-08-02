package br.com.softwareOptimus.fiscal.RN;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.dao.fiscal.PautaDAO;
import br.com.softwareOptimus.dao.fiscal.PautaMVADAO;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.util.DAOFactory;

public class PautaRN {

	private PautaDAO pautaDAO;
	private PautaMVADAO pautaMVADAO;
	
	public PautaRN() {
		this.pautaDAO = DAOFactory.criaPautaDAO();
		this.pautaMVADAO = DAOFactory.criaPautaMVADAO();
	}
	
	public void salvar(Pauta pauta) {
		this.pautaDAO.salvar(pauta);		
	}

	public List<PautaMVA> listar(Pauta pauta) throws Exception {
		return this.pautaMVADAO.listar(pauta);
	}

	public void salvaVig(PautaMVA pautaMVA) {
		this.pautaMVADAO.salva(pautaMVA);		
	}

	
	public Integer validaCampoNulo(Pauta pauta) {
		Integer retorno = 0;
		if (pauta.getDescricao().equals("")) {
			retorno = 1;
		}
		return retorno;
	}
	
	public Integer validaCampoNuloVig(PautaMVA pauta) {
		Integer retorno = 0;
		if (pauta.getDescricao().equals("") || pauta.getValorMVa() == null
				|| pauta.getVigencia() == null || pauta.getValorPauta() == null) {
			retorno = 1;
		}
		return retorno;
	}

	public void removerVig(Long idPautaMVA) {
		this.pautaMVADAO.remover(idPautaMVA);
	}

	public List<Pauta> consultaId(Long id) {
		return this.pautaDAO.listaConsultaId(id);
	}

	public List<Pauta> consultaDesc(String desc) {
		return this.pautaDAO.consultaDesc(desc);
	}

	public List<Pauta> listar() {
		return this.pautaDAO.consulta();
	}
	
	public List<Pauta> consPautVig() {
		return this.pautaDAO.consPautVig();
	}

	public Pauta editPauta(Long id) {
		return this.pautaDAO.consultaId(id);
	}

	public void altPauta(Pauta pauta) {
		this.pautaDAO.alterar(pauta);
	}

	public void remover(Pauta pauta) throws IOException, SQLException {
		this.pautaDAO.remover(pauta);
	}

	public Integer verificaRemocao(Pauta pauta) {
		List<GradeTributariaVigencia> grade = pautaDAO.verificaRemocao(pauta);
		if (grade.size() != 0){
			return 1;
		}else{
			return 0;
		}

	}

	public int countPautaPaginacao(Pauta pauta) {
		return this.pautaDAO.countPautaPaginacao(pauta);
	}

	public List<Pauta> buscaPautaPaginacao(Pauta pauta, int first, int pageSize) {
		return this.pautaDAO.buscaPautaPaginacao(pauta, first, pageSize);
	}
}
