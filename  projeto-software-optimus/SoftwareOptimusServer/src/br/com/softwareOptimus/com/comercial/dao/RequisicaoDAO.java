package br.com.softwareOptimus.com.comercial.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.comercial.Requisicao;

public interface RequisicaoDAO {

	public void begin() throws IOException, SQLException;

	public void close() throws Exception;

	public List<Requisicao> lista() throws Exception;

	public Requisicao requisicao(Long id) throws Exception;

}
