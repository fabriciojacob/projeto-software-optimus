package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.fiscal.Aliquota;

public interface AliquotaDAO {

	public void altAliq(Aliquota aliquota) throws Exception;
	public Aliquota editBusc(Long id);
	public void remover(Long id) throws Exception;
	public List<Aliquota> lista();
	public void salva(Aliquota aliq) throws Exception;
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<Aliquota> consultaId(long parseLong);
	public List<Aliquota> consultaAliq(Double busca);
	public List<Aliquota> consultaRed(Double busca);
	public List<Aliquota> listaAliqIcms();
}
