package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.financeiro.CondPgto;
import br.com.softwareOptimus.financeiro.RN.CondPgtoRN;
import br.com.softwareOptimus.util.Geral;

@ManagedBean
@ViewScoped
public class CondPgtoBens implements Geral{
	
	private CondPgto condPgto;
	private CondPgtoRN condRN;
	private List<CondPgto> lista = new ArrayList<>();
	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void selecionar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void novo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void msgAcerto(String msg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void msgErro(String msg, Exception e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}
	public CondPgto getCondPgto() {
		return condPgto;
	}
	public void setCondPgto(CondPgto condPgto) {
		this.condPgto = condPgto;
	}
	public CondPgtoRN getCondRN() {
		return condRN;
	}
	public void setCondRN(CondPgtoRN condRN) {
		this.condRN = condRN;
	}
	public List<CondPgto> getLista() {
		return lista;
	}
	public void setLista(List<CondPgto> lista) {
		this.lista = lista;
	}

}
