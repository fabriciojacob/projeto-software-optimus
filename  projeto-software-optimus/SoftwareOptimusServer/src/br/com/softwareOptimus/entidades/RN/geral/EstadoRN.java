package br.com.softwareOptimus.entidades.RN.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.dao.geral.EstadoDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class EstadoRN {

	private EstadoDAO estadoDAO;

	public EstadoRN() {
		this.estadoDAO = DAOFactory.criaEstadoDAO();
	}

	public List<Estado> listaEstado() {
		return this.estadoDAO.listar();
	}

}
