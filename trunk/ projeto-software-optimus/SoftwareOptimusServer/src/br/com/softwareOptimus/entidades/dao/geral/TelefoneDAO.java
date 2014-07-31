package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.Telefone;

public interface TelefoneDAO {
	
	public void salvar(Telefone telefone) throws Exception;
	public void excluir(Long idTel) throws Exception;
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<Telefone> listaTelefone(Pessoa pessoa) throws Exception;

}
