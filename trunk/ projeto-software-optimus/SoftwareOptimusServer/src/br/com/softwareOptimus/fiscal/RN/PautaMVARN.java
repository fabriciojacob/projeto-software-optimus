package br.com.softwareOptimus.fiscal.RN;

import java.util.List;
import br.com.softwareOptimus.dao.fiscal.PautaMVADAO;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.util.DAOFactory;

public class PautaMVARN {

	private PautaMVADAO pautaMVADAO;

	public PautaMVARN() {
		this.pautaMVADAO = DAOFactory.criaPautaMVADAO();
	}

	public void salva(PautaMVA pauta) {
		this.pautaMVADAO.salva(pauta);
	}

	public void altPauta(PautaMVA pauta) {
		this.pautaMVADAO.alterar(pauta);
	}

	public void remover(PautaMVA pauta) {
		this.pautaMVADAO.remover(pauta);
	}

	public List<PautaMVA> lista() {
		return this.pautaMVADAO.lista();
	}

	public List<PautaMVA> consultaId(long parseLong) {
		return this.pautaMVADAO.consultaId(parseLong);
	}

	public List<PautaMVA> consultaDesc(String busca) {
		return this.pautaMVADAO.consultaDesc(busca);
	}

	public List<PautaMVA> consultaValP(double parseDouble) {
		return this.pautaMVADAO.consultaValP(parseDouble);
	}

	public List<PautaMVA> consultaValMva(double parseDouble) {
		return this.pautaMVADAO.consultaMva(parseDouble);
	}

	public PautaMVA editPauta(Long id) {
		return this.pautaMVADAO.editPauta(id);
	}

	public Integer validaCampoNulo(PautaMVA pauta) {
		Integer retorno = 0;
		if (pauta.getDescricao().equals("") || pauta.getValorMVa() == null
				|| pauta.getVigencia() == null || pauta.getValorPauta() == null) {
			retorno = 1;
		}
		return retorno;
	}

	public List<PautaMVA> listar(Pauta pauta) throws Exception {
		return this.pautaMVADAO.listar(pauta);
	}
}
