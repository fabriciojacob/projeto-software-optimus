package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.Pauta;

public interface PautaDAO {

	public void salvar(Pauta pauta);
	public Pauta consultaId(Long id);
	public List<Pauta> consultaDesc(String desc);
	public List<Pauta> consulta();
	public List<Pauta> consPautVig();
	public void alterar(Pauta pauta);
	public void remover(Pauta pauta) throws IOException, SQLException;
	public List<Pauta> listaConsultaId(Long id);
	public List<GradeTributariaVigencia> verificaRemocao(Pauta pauta);
	public int countPautaPaginacao(Pauta pauta);
	public List<Pauta> buscaPautaPaginacao(Pauta pauta, int first, int pageSize);
	public void defineCondicao(StringBuilder sql, Pauta pauta);
	public void defineParametros(Query qry, Pauta pauta);
}
