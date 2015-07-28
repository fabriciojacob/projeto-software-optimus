package br.com.softwareOptimus.comercial.bens;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.softwareOptimus.comercial.Requisicao;
import br.com.softwareOptimus.comercial.RN.RequisicaoRN;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.produto.Produto;

@ManagedBean
@ViewScoped
public class RequisicaoBens {
	
	private Requisicao requisicao;
	private List<Pessoa> listaEmpresas;
	private Long idEmpresa;
	private Pessoa empSelecionada;
	private List<Produto> listaProdutos;
	private RequisicaoRN requisicaoRN;
	
	public RequisicaoBens(){
		
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public List<Pessoa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Pessoa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Pessoa getEmpSelecionada() {
		return empSelecionada;
	}

	public void setEmpSelecionada(Pessoa empSelecionada) {
		this.empSelecionada = empSelecionada;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public RequisicaoRN getRequisicaoRN() {
		return requisicaoRN;
	}

	public void setRequisicaoRN(RequisicaoRN requisicaoRN) {
		this.requisicaoRN = requisicaoRN;
	}

}
