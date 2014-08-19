package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.fiscal.PautaMVA;

public interface PautaMVADAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void alterar(PautaMVA pauta);
	public void remover(PautaMVA pauta);
	public List<PautaMVA> lista();
	public List<PautaMVA> consultaId(long parseLong);
	public List<PautaMVA> consultaDesc(String busca);
	public List<PautaMVA> consultaValP(double parseDouble);
	public List<PautaMVA> consultaMva(double parseDouble);
	public PautaMVA editPauta(Long id);
	public void salva(PautaMVA pauta);
	public List<PautaMVA> listar(Long idPauta);
}
