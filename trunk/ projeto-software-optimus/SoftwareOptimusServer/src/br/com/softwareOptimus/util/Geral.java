package br.com.softwareOptimus.util;

public interface Geral {
	
	public void salvar();
	
	public void selecionar();
	
	public void editar();
	
	public void pesquisar();
	
	public void novo();
	
	public void msgAcerto(String msg);

	public void msgErro(String msg, Exception e);
	
	public void excluir();

}
