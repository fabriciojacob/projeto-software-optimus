package br.com.softwareOptimus.pesquisasGeraisBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaSubGrupoBean")
@ViewScoped
public class PesquisaSubGrupoBean extends FacesUtil implements Serializable {


	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaSubGrupoBean(){

	}
	
	public void selecionaAliquota(Grupo grupo){
		RequestContext.getCurrentInstance().closeDialog(grupo);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaSubGrupo", opcoes, null);
	}
}
