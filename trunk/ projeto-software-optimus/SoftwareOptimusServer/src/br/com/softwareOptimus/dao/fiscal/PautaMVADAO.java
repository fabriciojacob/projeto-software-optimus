package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.PautaMVA;

public interface PautaMVADAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void alterar(PautaMVA pauta);
	public void remover(Long idPautaMVA);
	public void salva(PautaMVA pauta);
	public PautaMVA editPauta(Long id);
	public List<PautaMVA> listar(Pauta pauta) throws Exception;
	public List<PautaMVA> consultaDesc(String busca);
}
