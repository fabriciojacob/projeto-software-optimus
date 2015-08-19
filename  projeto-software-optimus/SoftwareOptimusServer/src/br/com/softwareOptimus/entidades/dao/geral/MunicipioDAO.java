package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Municipio;

public interface MunicipioDAO {
	
	public List<Municipio> lista(Estado uf);
}
