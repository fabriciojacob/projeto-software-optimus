package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;

public interface RegimeDAO {
	
	public List<VigenciaRegime> listaRegime(PessoaJuridica pessoaJuridica) throws Exception;
	
	public void begin()  throws IOException, SQLException;
	
	public void close()  throws Exception;

}
