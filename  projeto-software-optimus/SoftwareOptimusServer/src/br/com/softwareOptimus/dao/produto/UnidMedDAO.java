package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.produto.UnidMed;

public interface UnidMedDAO {

	public List<UnidMed> consultarUnid(String unid);

	public List<UnidMed> consultarDesc(String desc);

	public List<UnidMed> consultarId(Long id);

	public void altUnid(UnidMed unidMed);

	public UnidMed editBusc(Long id);

	public void remover(Long id);

	public List<UnidMed> lista();

	public void salvar(UnidMed unid);

	public void begin() throws IOException, SQLException;

	public void close() throws Exception;
}
