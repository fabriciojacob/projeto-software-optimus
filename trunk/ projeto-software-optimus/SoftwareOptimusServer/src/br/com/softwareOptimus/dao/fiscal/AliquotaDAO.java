package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.fiscal.Aliquota;

public interface AliquotaDAO {

	public List<Aliquota> consultar(Long id);
	public void altUnid(Aliquota aliquota) throws Exception;
	public Aliquota editBusc(Long id);
	public void remover(Long id) throws Exception;
	public List<Aliquota> lista();
	public void salvar(Aliquota aliq);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
}
