package web;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import conta.Conta;
import conta.ContaRN;
import usuario.Usuario;
import usuario.UsuarioRN;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmaSenha;
	private List<Usuario> lista;
	private String destinoSalvar;
	private Conta conta = new Conta();
	
	public String novo() {
		this.destinoSalvar = "usuariosucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}
	
	public String editar() {
		this.confirmaSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		String senha = this.usuario.getSenha();
		if(!senha.equals(confirmaSenha)) {
			FacesMessage facesMessage = new FacesMessage("a senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		
		if(this.conta.getDescricao() != null) {
			this.conta.setUsuario(this.usuario);
			this.conta.setFavorita(true);
			ContaRN contaRN = new ContaRN();
			contaRN.salvar(conta);
		}
		
		return this.destinoSalvar;
		
	}
	
	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}
	
	public String ativar() {
		if(this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
		}else {
			this.usuario.setAtivo(true);
		}
		return null;
	}
	
	public String atribuirPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		Set<String> permissoes = this.usuario.getPermissao();
		if(permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		}else {
			permissoes.add(permissao);
		}
		return null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public List<Usuario> getLista() {
		if(this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
	
}
