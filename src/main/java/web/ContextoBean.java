package web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import conta.Conta;
import conta.ContaRN;
import usuario.Usuario;
import usuario.UsuarioRN;

@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4083574489214056625L;
	/**
	 * 
	 */
	
	
	private int codigoContaAtiva = 0;
	
	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if(login != null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			return usuarioRN.buscaPorLogin(login);
		}
		
		return null;
	}
	
	public Conta getContaAtiva() {
		Conta contaAtiva = null;
		if(this.codigoContaAtiva == 0) {
			contaAtiva = this.getContaAtivaPadrao();
		}else {
			ContaRN contaRN = new ContaRN();
			contaAtiva = contaRN.carregar(this.codigoContaAtiva);
		}
		if(contaAtiva != null) {
			this.codigoContaAtiva = contaAtiva.getConta();
			return contaAtiva;
		}
		return null;
	}

	private Conta getContaAtivaPadrao() {
		ContaRN contaRN = new ContaRN();
		Conta contaAtiva = null;
		Usuario usuario = this.getUsuarioLogado();
		contaAtiva = contaRN.buscarFavorita(usuario);
		if(contaAtiva == null) {
			List<Conta> contas = contaRN.listar(usuario);
			if(contas != null && contas.size() > 0) {
				contaAtiva = contas.get(0);
			}
		}
		
		return contaAtiva;
	}
	
	public void changeContaAtiva(ValueChangeEvent event) {
		this.codigoContaAtiva = (Integer) event.getNewValue();
	}
}
