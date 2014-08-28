package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.Pauta;

public interface GradeTributariaVigenciaDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<GradeTributariaVigencia> listaVig(GradeTributaria grade);
	public void remover(Long idGradeVig);
	public void salvaVig(GradeTributariaVigencia gradeVig);
	public List<GradeTributariaVigencia> validaInclusao(Estado origem, Estado destino,
			Aliquota aliquota, IO io, TipoPessoaJuridica tipoGrade,
			Date vigencia, Pauta pauta);
}
