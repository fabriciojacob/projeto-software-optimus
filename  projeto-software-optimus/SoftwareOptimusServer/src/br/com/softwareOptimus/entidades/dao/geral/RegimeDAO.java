package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;

public interface RegimeDAO {
	
	public List<VigenciaRegime> listaRegime(PessoaJuridica pessoaJuridica) throws Exception;
	public void excluirRegime(Long idRegime) throws Exception;

}
