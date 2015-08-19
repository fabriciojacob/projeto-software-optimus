package br.com.softwareOptimus.dao.fiscal;

import java.util.List;

import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;

public interface CodigoSituacaoTributariaDAO {

	public List<CodigoSituacaoTributaria> cstListaIcms();
	public List<CodigoSituacaoTributaria> cstListaOut(TipoCst tipo, IO entSai);
}
