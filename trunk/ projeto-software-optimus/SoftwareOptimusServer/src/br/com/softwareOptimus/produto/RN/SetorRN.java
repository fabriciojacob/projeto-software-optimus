package br.com.softwareOptimus.produto.RN;

import java.util.List;

import br.com.softwareOptimus.dao.produto.SetorDAO;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.util.DAOFactory;

public class SetorRN {
	
	private SetorDAO setorDAO;
	
	public SetorRN(){
		this.setorDAO = DAOFactory.criaSetorDAO();
	}

	public Integer validaCampoNulo(Setor setor) {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Setor setor) {
		// TODO Auto-generated method stub
		
	}

	public void altSet(Setor setor) {
		// TODO Auto-generated method stub
		
	}

	public Integer verificaRemocao(Setor setor) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remover(Setor setor) {
		// TODO Auto-generated method stub
		
	}

	public List<Setor> consultaId(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Setor> consultaDesc(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Setor> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Setor editSet(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
