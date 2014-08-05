package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;

public interface CodigoSituacaoTributariaDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<CodigoSituacaoTributaria> cstListaIcms(TipoCst icms);
	public List<CodigoSituacaoTributaria> cstListaOut(TipoCst tipo, IO entSai);
}
