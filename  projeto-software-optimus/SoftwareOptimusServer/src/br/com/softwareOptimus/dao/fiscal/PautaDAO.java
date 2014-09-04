package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.Pauta;

public interface PautaDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(Pauta pauta);
	public Pauta consultaId(Long id);
	public List<Pauta> consultaDesc(String desc);
	public List<Pauta> consulta();
	public void alterar(Pauta pauta);
	public void remover(Pauta pauta) throws IOException, SQLException;
	public List<Pauta> listaConsultaId(Long id);
	public List<GradeTributariaVigencia> verificaRemocao(Pauta pauta);
}
