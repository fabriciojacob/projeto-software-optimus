package br.com.softwareOptimus.comercial.bens;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;
import br.com.softwareOptimus.comercial.Requisicao;
import br.com.softwareOptimus.comercial.StatusGeral;
import br.com.softwareOptimus.comercial.RN.RequisicaoRN;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.entidades.RN.UsuarioRN;
import br.com.softwareOptimus.produto.Produto;

@ManagedBean
@ViewScoped
public class RequisicaoBean {

	private Requisicao requisicao;
	private Long idEmpresa, idUsuario;
	private Pessoa empSelecionada;
	private List<Produto> listaProdutos;
	private List<Requisicao> listaRequisicao;
	private RequisicaoRN requisicaoRN;
	private Usuario user =  new Usuario();
	private boolean reqDesc = true, reqEmpr = true, reqData = true,
			btNovo = false, btSalvar = true, btEdit = true, btExcluir = true, reqOb = true,
			btVincUser = true, tipoReq = true, btEnviReq = true;
	private UsuarioRN usuarioRN;
	private Usuario usuario;
	private String tipoRequisicao, descReq;
	
	public RequisicaoBean() {
		this.requisicao = new Requisicao();
		requisicaoRN 	= new RequisicaoRN();
	}

	public void checkRegraNull() {
		if (this.requisicaoRN == null) {
			this.requisicaoRN = new RequisicaoRN();
		}
	}

	public void ativaBool() {
		this.reqData = true;
		this.reqDesc = true;
		this.reqData = true;
		this.reqEmpr = true;
		this.reqOb		= true;
		this.btNovo 	= true;
		this.btEdit 	= true;
		this.btExcluir 	= true;
		this.btSalvar 	= true;
		this.btVincUser = true;
		this.tipoReq	= true;
	}
	
	public void excluir(){
		ativaBool();
		this.btNovo = false;
		try{
			int i = requisicaoRN.excluir(requisicao);
			
			if(i == 0){
				msgAcerto("Registro excluido com sucesso !!!");
			}else{
				msgErro("Requisição já enviada, exclusão abortada" , null);
			}
			
			requisicao = new Requisicao();
		}catch (Exception ex){
			msgErro("Problemas ao excluir o registro ", ex);
		}
	}

	public void inativaBoolNovo() {
		this.reqData = false;
		this.reqDesc = false;
		this.reqData = false;
		this.reqEmpr = false;
		this.reqOb		= false;
		this.btNovo 	= false;
		this.btSalvar 	= false;
		this.btVincUser = false;
		this.tipoReq	= false;
	}
	
	public void ativaBoolSalvar(){
		this.btEdit 	= true;
		this.btExcluir 	= true;
	}
	
	public void editar(int tipoOper){
		salvar(tipoOper);
	}
	
	public void enviarRequisicao(){
		this.requisicao.setStatusGeral(StatusGeral.ENVIADA);
		try{
			editar(2);
			msgAcerto("Requisição enviada!!!");
		}catch (Exception ex){
			msgErro("Erro ao enviar a requisição !!!", ex);
		}
	}
	
	public void inativaBoolSalvar(){
		this.btEdit 	= false;
		this.btExcluir 	= false;
	}

	public void novo() {
		this.requisicao = new Requisicao();
		inativaBoolNovo();
		ativaBoolSalvar();
	}

	public void salvar(int tipoOper) {
		try {
			String check = requisicaoRN.salvar(requisicao, usuario, empSelecionada, tipoRequisicao,tipoOper);
			msgAcerto(check);
			inativaBoolSalvar();
			this.btSalvar = true;
			this.btEnviReq = false;
		} catch (Exception ex) {
			msgErro("Problemas ao salvar ou editar a requisicao", ex);
		}
	}

	public void selecionaUsuario() {
		if (this.idUsuario != null) {
			usuarioRN = new UsuarioRN();
		}
		try {
			usuario = usuarioRN.carregar(idUsuario);
		} catch (Exception ex) {
			msgErro("Problemas na seleção do usuário ", ex);
		}
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Toggled", "Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
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

	public void msgAcerto(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
	}

	public void msgErro(String msg, Exception e) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", msg
						+ e.getMessage()));
	}

	public boolean isReqDesc() {
		return reqDesc;
	}

	public void setReqDesc(boolean reqDesc) {
		this.reqDesc = reqDesc;
	}

	public boolean isReqData() {
		return reqData;
	}

	public void setReqData(boolean reqData) {
		this.reqData = reqData;
	}

	public boolean isReqEmpr() {
		return reqEmpr;
	}

	public void setReqEmpr(boolean reqEmpr) {
		this.reqEmpr = reqEmpr;
	}

	public boolean isBtNovo() {
		return btNovo;
	}

	public void setBtNovo(boolean btNovo) {
		this.btNovo = btNovo;
	}

	public boolean isBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(boolean btSalvar) {
		this.btSalvar = btSalvar;
	}

	public boolean isBtEdit() {
		return btEdit;
	}

	public void setBtEdit(boolean btEdit) {
		this.btEdit = btEdit;
	}

	public boolean isBtExcluir() {
		return btExcluir;
	}

	public void setBtExcluir(boolean btExcluir) {
		this.btExcluir = btExcluir;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}

	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isBtVincUser() {
		return btVincUser;
	}

	public void setBtVincUser(boolean btVincUser) {
		this.btVincUser = btVincUser;
	}

	public String getTipoRequisicao() {
		return tipoRequisicao;
	}

	public void setTipoRequisicao(String tipoRequisicao) {
		this.tipoRequisicao = tipoRequisicao;
	}

	public boolean isTipoReq() {
		return tipoReq;
	}

	public void setTipoReq(boolean tipoReq) {
		this.tipoReq = tipoReq;
	}

	public boolean isBtEnviReq() {
		return btEnviReq;
	}

	public void setBtEnviReq(boolean btEnviReq) {
		this.btEnviReq = btEnviReq;
	}

	public String getDescReq() {
		return descReq;
	}

	public void setDescReq(String descReq) {
		this.descReq = descReq;
	}

	public List<Requisicao> getListaRequisicao() {
		return listaRequisicao;
	}

	public void setListaRequisicao(List<Requisicao> listaRequisicao) {
		this.listaRequisicao = listaRequisicao;
	}

	public boolean isReqOb() {
		return reqOb;
	}

	public void setReqOb(boolean reqOb) {
		this.reqOb = reqOb;
	}

}
