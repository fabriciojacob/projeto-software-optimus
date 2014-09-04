package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;

public interface GradeTributariaDAO {
	
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(GradeTributaria grade);
	public void altGrade(GradeTributaria grade);
	public void remover(GradeTributaria grade) throws IOException, SQLException;
	public List<GradeTributaria> listaConsultaId(long id);
	public List<GradeTributaria> listaConsultaDesc(String busca);
	public List<GradeTributaria> listar();
	public GradeTributaria consultaId(Long id);
	public List<FiguraFiscal> verificaRemocao(GradeTributaria grade);
}
