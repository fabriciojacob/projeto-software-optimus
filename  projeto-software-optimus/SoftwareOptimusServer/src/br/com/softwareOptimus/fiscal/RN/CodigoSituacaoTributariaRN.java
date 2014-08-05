package br.com.softwareOptimus.fiscal.RN;

import java.util.List;

import br.com.softwareOptimus.dao.fiscal.CodigoSituacaoTributariaDAO;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;
import br.com.softwareOptimus.util.DAOFactory;

public class CodigoSituacaoTributariaRN {
	
	private CodigoSituacaoTributariaDAO cstDAO;
	
	public CodigoSituacaoTributariaRN(){
		this.cstDAO = DAOFactory.criaCodigoSituacaoTributariaDAO();
	}

	public List<CodigoSituacaoTributaria> cstListaIcms(TipoCst icms) {
		return cstDAO.cstListaIcms(icms);
	}

	public List<CodigoSituacaoTributaria> cstListaOut(TipoCst tipo, IO entSai) {
		return cstDAO.cstListaOut(tipo, entSai);
	}

}
